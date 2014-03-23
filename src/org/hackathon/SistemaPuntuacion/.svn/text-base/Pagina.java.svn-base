package org.hackathon.SistemaPuntuacion;

public class Pagina implements Comparable<Object> {
	
	private String titulo;
	private String consulta;
	private String enlace;
	private String portal;
	private int puntuacionTotal;
	private int numValoraciones;
	
	public Pagina(String consulta, String titulo, String enlace, String portal, String puntuacion, String numValoraciones){
		this.titulo = titulo;
		this.consulta=consulta;
		this.enlace=enlace;
		this.portal=portal;
		this.puntuacionTotal=Integer.valueOf(puntuacion);
		this.numValoraciones=Integer.valueOf(numValoraciones);
	}
	public void addPuntuacionTotal(int puntuacion){
		this.puntuacionTotal+=puntuacion;
		this.numValoraciones++;
	}
	public int verRanking(){
		return Math.round(puntuacionTotal/numValoraciones);
	}

/////////////////Get y set///////////////////
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public int getPuntuacionTotal(){
		return this.puntuacionTotal;
	}
	public int getNumValoraciones(){
		return this.numValoraciones;
	}
	///////////////////REPRESENTACIONES/////////////////////
	public String toString(){
		//String consulta, String titulo, String enlace, String portal, String puntuacion, String numValoraciones
		//pilas java; Stack in android; http://stackoverflow.com/questions/3767536/stack-in-android; stackoverflow.com; 100; 25
		String salida ="";
		salida = getConsulta() 			+"; "+
				 getTitulo() 			+"; "+
				 getEnlace()			+"; "+
				 getPortal()			+"; "+
				 getPuntuacionTotal() 	+"; "+
				 getNumValoraciones();
		return salida;
	}
	public String rankingToString(){
		String salida ="";
		salida+=
				getTitulo() + " - " +
				getEnlace() + " - " +		
				verRanking()+ "  "  +
				estrellas();
		return salida;
	}
	public String estrellas(){
		String salida="";
		for(int i=0; i<verRanking();i++){
			salida+="*";
		}
		return salida;
	}
	@Override
	public int compareTo(Object o) {
		Pagina aux = (Pagina) o;
		
		if(verRanking() > aux.verRanking())
			return -1;
		if(verRanking() < aux.verRanking())
			return 1;
		else
			return 0;
	}
}
