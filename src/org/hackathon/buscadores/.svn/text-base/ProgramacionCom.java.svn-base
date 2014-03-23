package org.hackathon.buscadores;

import java.io.IOException;
import java.util.ArrayList;

import org.hackathon.buscadores.LaWebDelProgramador.LinkForum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProgramacionCom {
	

	 public class LinkForum{
		 
		 private String enlace;
		 private String titulo;
		 private String descripcion;
		 
	LinkForum(String enlace, String titulo, String descripcion){
		this.enlace = enlace;
		this.titulo = titulo;
		this.descripcion = descripcion;
		
	}
	
	public String getEnlace(){
		return enlace;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public String toString() {
		return titulo+"---->"+enlace+"------>"+descripcion;
	}
}

	
	 public ArrayList<LinkForum> Scrap(String consulta)
	{
		 consulta = consulta.replaceAll(" ", "+");
		ArrayList<LinkForum> listPag = new ArrayList<LinkForum>();

		 Document doc;
		    try{
		        doc =        Jsoup.connect("https://www.google.es/search?q="+consulta).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
		        Elements links = doc.select("li[class=g]");
		        for (Element link : links) {
		        	Element enlace  = link.select("a").first();
		            String href = "www.google.com"+enlace.attr("href");
		            Elements titles = link.select("h3[class=r]");
		            String texto = titles.text();

		            Elements bodies = link.select("span[class=st]");
		            String body = bodies.text();

		        	listPag.add(new LinkForum(href, texto, body) );
		        	System.out.println(href);
		        	System.out.println(texto);
		        	System.out.println(body);
		            
		        }
		    }
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		    return listPag;
	}


	 public static void main(String[] args) {
		ProgramacionCom  o =  new ProgramacionCom();
		o.Scrap("lo que sea");
	}
}
