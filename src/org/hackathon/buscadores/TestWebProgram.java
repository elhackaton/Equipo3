package org.hackathon.buscadores;

import java.util.ArrayList;

import org.hackathon.buscadores.LaWebDelProgramador.LinkForum;

public class TestWebProgram {

	public static void main(String[] args) {
		LaWebDelProgramador web = new LaWebDelProgramador();
		
	ArrayList<LinkForum> link =	web.programacionForo("listas", 44);
	
	for (int i = 0; i < link.size(); i++) {
		System.out.println("http://www.lawebdelprogramador.com/"+link.get(i));
		
	}
		
		
		System.out.println(web.programadorQuestion("listas", 44));
	}

}
