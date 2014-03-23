package org.hackathon.SistemaPuntuacion;

import java.util.ArrayList;

import org.hackathon.SistemaPuntuacion.*;
import org.hackathon.buscadores.*;
import org.hackathon.buscadores.LaWebDelProgramador.LinkForum;

public class ListadoConsulta {
	private PaginasValoradas listaSistema;
	private LaWebDelProgramador listaWeb;
	private String resultadoConsulta;
	
	public ListadoConsulta(){
		this.listaSistema = new PaginasValoradas();
		this.listaWeb = new LaWebDelProgramador();
		listaSistema.cargarArchivo();
	}
	public String agruparResultados(String consulta, String lenguaje){
		PaginasValoradas pagSistema = new PaginasValoradas();
		LaWebDelProgramador pagBusquedaWeb = new LaWebDelProgramador();
		pagSistema.cargarArchivo();
		String salida="";
		salida+=pagSistema.listadoPorRankingConsulta(consulta +" " +lenguaje);
		salida+="\n";
		ArrayList<LinkForum> auxArray = null;
		if(lenguaje.equals("java")){
			auxArray = pagBusquedaWeb.programacionForo(consulta, 44);
			salida+=pagBusquedaWeb.listaWeb(auxArray);
		}
		else if(lenguaje.equals("c#")){
			auxArray = pagBusquedaWeb.programacionForo(consulta, 227);
			salida+=pagBusquedaWeb.listaWeb(auxArray);
		}
		return salida;
	}
	public boolean addPuntuacion(String enlace, int puntuacion){
		return this.listaSistema.addPuntuacion(enlace, puntuacion);
	}
}