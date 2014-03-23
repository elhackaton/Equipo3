package org.hackathon.SistemaUsuario;

import java.util.TreeMap;

public class Usuario {

	private String user;
	private String pass;
	private TreeMap<String, Integer> puntos;
	
	public Usuario(String user, String pass){
		this.user = user;
		this.pass = pass;
		puntos = new TreeMap<String, Integer>();
	}
	public Usuario(String user, String pass, TreeMap<String, Integer> puntuaciones){
		this.user = user;
		this.pass = pass;
		this.puntos = puntuaciones;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public TreeMap<String, Integer> getPuntos() {
		return puntos;
	}
	
	public void addPuntuacion(String lenguaje,int puntuacion){
		puntos.put(lenguaje, puntuacion);
	}
	public boolean aumentarPuntuacion(String lenguaje, int puntuacion){
		int puntuacionNueva = getPuntos().get(lenguaje) + puntuacion;
		return setPuntos(lenguaje,puntuacionNueva);
	}
	private boolean setPuntos(String lenguaje, int puntuacionNueva) {
		return this.getPuntos().put(lenguaje, puntuacionNueva) != null;
	}

	
}
