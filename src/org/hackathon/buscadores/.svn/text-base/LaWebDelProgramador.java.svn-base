package org.hackathon.buscadores;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LaWebDelProgramador {
	
 public class LinkForum{
	 
	 private String enlace;
	 private String titulo;
	 
		LinkForum(String enlace, String titulo){
			this.enlace = enlace;
			this.titulo = titulo;	
		}
		
		public String getEnlace(){
			return enlace;
		}
		
		public String getTitulo(){
			return titulo;
		}
		
		public String toString() {
			return titulo+" - "+enlace;
		}
	}
 
	
	public String programadorQuestion (String consulta, int lenguaje)
	{
		       return "http://www.lawebdelprogramador.com/preguntas/buscarr.php?id=&texto=&cadena="+consulta+"&lenguaje="+lenguaje;
		       }
		  	
	public ArrayList<LinkForum> programacionForo(String consulta, int lenguaje){
		
		String url = "http://www.lawebdelprogramador.com/foros/buscar.php?opc=1&id="+lenguaje+"&charSearch="+consulta;
		ArrayList<LinkForum> listPag = new ArrayList<LinkForum>();
		
		
		Document doc;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
		
        Elements links = doc.select(".forosList a");
        for (Element link : links) {
        	String href = "http://www.lawebdelprogramador.com"+link.attr("href");
        	String texto = link.select(".title").text();
        	
        	
        	listPag.add(new LinkForum(href, texto));
        	
//            System.out.println("Title: "+href);
//             System.out.println("Body: "+texto+"\n");
        	}
        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listPag;
	}
	public String listaWeb(ArrayList<LinkForum> listaWebObject){
		String salida="";
		for(int i=0; i<listaWebObject.size();i++){
			salida+=listaWebObject.get(i).toString() +"\n";
		}
		return salida;
	}

}
