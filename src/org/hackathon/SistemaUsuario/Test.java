package org.hackathon.SistemaUsuario;

public class Test {
	
	public static void main(String[] args) {
		Autentificacion auten = new Autentificacion();
		auten.cargarArchivo();
		System.out.println(auten.listadoUsuario());
		System.out.println(auten.rankingPorLenguaje("java"));
		auten.guardarUsuarios();
	}
}
