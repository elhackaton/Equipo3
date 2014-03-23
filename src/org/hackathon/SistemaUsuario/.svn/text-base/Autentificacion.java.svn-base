package org.hackathon.SistemaUsuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import org.hackathon.SistemaPuntuacion.Pagina;

public class Autentificacion {
	private static String archivo =System.getProperty("user.dir") + File.separator +
			"src" + File.separator +
			"org" + File.separator +
			"hackathon" + File.separator +
			"datos" + File.separator     +
			"usuarios.txt";
	private TreeMap<String, Usuario> usuarios;
	
	public Autentificacion(){
		this.usuarios = new TreeMap<String, Usuario>();
	}
	public void cargarArchivo(){		
		try{
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			while (lector.ready()){
				String linea = lector.readLine();
				String [] arrayLinea = linea.split("; ");
				try{
					String user = arrayLinea[0];
					String pass = arrayLinea[1];
					//System.out.println(user +" "+ pass);
					TreeMap<String, Integer> puntuaciones = new TreeMap<String, Integer>();
					if(arrayLinea.length>2){
						for(int i=2; i<arrayLinea.length;i++){
							String [] puntuacion = arrayLinea[i].split(":");
							puntuaciones.put(puntuacion[0], Integer.parseInt(puntuacion[1]));
							//System.out.println(puntuacion[0]+":"+puntuacion[1]);
						}
					}
					this.usuarios.put(user, new Usuario(user, pass, puntuaciones));
				}
				catch(Exception e){
					System.out.println("Error al cargar la linea");
				}
			}
			lector.close();
			}
		catch(IOException e){
			System.out.println("Error al cargar el archivo");
		}
	}
	
	public String rankingPorLenguaje(String lenguaje){
		String salida="";
		TreeMap<Integer, String> mapa = new TreeMap<Integer, String>();
		Iterator<String> iterUser = this.usuarios.keySet().iterator();
		while(iterUser.hasNext()){
			String usuario = iterUser.next();
			Iterator<String> iterLen = this.usuarios.get(usuario).getPuntos().keySet().iterator();
			while(iterLen.hasNext()){
				String leng = iterLen.next();
				if(leng.equals(lenguaje)){
					mapa.put(this.usuarios.get(usuario).getPuntos().get(leng), usuario);
				}
			}
		}
		Iterator<Integer> iterRanking = mapa.descendingKeySet().iterator();
		while(iterRanking.hasNext()){
			Integer puntos = iterRanking.next();
			salida+=mapa.get(puntos)+" - "+puntos;
			salida+="\n";
		}
		return salida;
	}
	public String listadoUsuario(){
		String salida="";
		Iterator<String> iterUser = this.usuarios.keySet().iterator();
		while(iterUser.hasNext()){
			String usuario = iterUser.next();
			salida+=usuarios.get(usuario).getUser()+"-"+usuarios.get(usuario).getPass()+"-->";
			Iterator<String> iterLen = this.usuarios.get(usuario).getPuntos().keySet().iterator();
			while(iterLen.hasNext()){
				String lenguaje = iterLen.next();
				salida+=lenguaje +"-"+ this.usuarios.get(usuario).getPuntos().get(lenguaje);
			}
			salida+="\n";
		}
		return salida;
	}
	
	public int autentificar(String cadenaAutentificar){
		String usuario = cadenaAutentificar.split(":")[0];
		String pass = cadenaAutentificar.split(":")[1];
		
		if(!this.usuarios.containsKey(usuario))
			return 1;	//Usuario no existe
		else{
			if(this.usuarios.get(usuario).getPass().equals(pass)){
				return 0; //Exito conectado
			}
			else{
				return 2; //Contraseña incorrecta
			}
		}
	}
	
	public void guardarUsuarios(){
		File archivoEntradas = new File(archivo);
		try {
			PrintWriter pw = new PrintWriter(archivoEntradas);
			
			String salida="";
			Iterator<String> iterUser = this.usuarios.keySet().iterator();
			while(iterUser.hasNext()){
				String usuario = iterUser.next();
				salida=usuarios.get(usuario).getUser()+"; "+usuarios.get(usuario).getPass()+"; ";
				Iterator<String> iterLen = this.usuarios.get(usuario).getPuntos().keySet().iterator();
				while(iterLen.hasNext()){
					String lenguaje = iterLen.next();
					salida+=lenguaje +":"+ this.usuarios.get(usuario).getPuntos().get(lenguaje);
					if(iterLen.hasNext())
						salida+="; ";
				}
				pw.println(salida);
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
