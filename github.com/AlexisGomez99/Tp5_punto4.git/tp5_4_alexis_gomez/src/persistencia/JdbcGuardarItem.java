package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.ConsumirServicio;
import modelo.Item;

public class JdbcGuardarItem  implements ConsumirServicio{

	ConsumirServicio servicio;
	
	
	public JdbcGuardarItem(ConsumirServicio servicio) {
		super();
		this.servicio = servicio;
	}

	//cambiar id en base de datos como dato unico

	public void guardarItem(List<Item> lista) {
		Connection conexion = null;
		try {
			conexion = ConexionBD.getConection();
			conexion.setAutoCommit(false);
			Statement sent = conexion.createStatement();
			for(Item i: lista) {
				sent.executeUpdate("INSERT INTO `listaitems`(`userId`, `id`, `title`, `body`) "
						+ "VALUES ('"+i.itemId()+"','"+i.userId()+"','"+i.title()+"','"+i.body()+"')");
			}
			conexion.commit();
			conexion.close();

		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public String run() {
		String items= servicio.run();
		List<String> parts= Arrays.asList(items.split("[{,,,}]")); 
		
		int cada4=0;
		
		List<Item> listaItems= new ArrayList<Item>();
		String id = null, userid = null, title = null, body = null;
		String[] parts2 = null;
		
		for (int i = 1; i < parts.size(); i++) {
			parts2= parts.get(i).split(":"); 
			
			if(cada4<4) {
				if(cada4==0)
					id=parts2[1];
				if(cada4==1)
					userid=parts2[1];
				if(cada4==2)
					title=parts2[1];
				if(cada4==3)
					body=parts2[1];
				cada4++;
				if(cada4==4) {
					listaItems.add(new Item(id,userid,title,body));
					i+=2;
					cada4=0;
				}
			}
		}
		
		guardarItem(listaItems);
		return items;
	}
	
}