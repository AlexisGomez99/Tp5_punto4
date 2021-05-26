package persistencia;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import modelo.ConsumirServicio;

public class EnDiscoGuardarItem implements ConsumirServicio {
	private ConsumirServicio servicio;
	private String nombreArchivo;
	private String path;
	public EnDiscoGuardarItem(ConsumirServicio servicio) {
		super();
		this.servicio=servicio;
		this.nombreArchivo="Items";
		this.path="C:\\Users\\Alexis\\Desktop\\";
	}

	@Override
	public String run() {
		FileWriter archivoSalida;
		String items = this.servicio.run();
		try {

			File file = new File(this.path+""+this.nombreArchivo+".txt");
			archivoSalida = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(archivoSalida);
			buffer.write(items);
			buffer.close();
			Desktop.getDesktop().open(file);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return items;
	}
	
	

}
