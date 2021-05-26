package main;


import modelo.ConsumirServicio;

import modelo.RestCall;
import persistencia.EnDiscoGuardarItem;
import persistencia.JdbcGuardarItem;

public class Main {
	public static void main(String[] args) {
		ConsumirServicio consumirmixto= new JdbcGuardarItem(new EnDiscoGuardarItem(new RestCall("https://jsonplaceholder.typicode.com/posts")));
		consumirmixto.run();
	}
	
}