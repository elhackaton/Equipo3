package org.hackathon.SistemaPuntuacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PaginasValoradas {
	private TreeMap<String, TreeMap<String, TreeSet<Pagina>>> listaPaginasValoradas;
	private static String archivo =System.getProperty("user.dir") + File.separator +
			"src" + File.separator +
			"org" + File.separator +
			"hackathon" + File.separator +
			"datos" + File.separator     +
			"webs.txt";
	public PaginasValoradas(){
		this.listaPaginasValoradas = new TreeMap<String, TreeMap<String, TreeSet<Pagina>>>();
	}
	//////////////CARGAR//////////////
	public void cargarArchivo(){
		try{
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			while (lector.ready()){
				String linea = lector.readLine();
				String [] arrayLinea = linea.split("; ");
				try{
					//String consulta, String titulo, String enlace, String portal, String puntuacion, String numValoraciones
					String consulta = arrayLinea[0];
					String titulo = arrayLinea[1];
					String enlace = arrayLinea[2];
					String portal = arrayLinea[3];
					String puntuacion = arrayLinea[4];
					String numValoraciones = arrayLinea[5];
					
					Pagina pagina = new Pagina(consulta, titulo, enlace, portal, puntuacion, numValoraciones);
					if(!existe(pagina))
						agregarPaginaWeb(pagina);				
					
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
	
	//////////////LISTADOS//////////////
	public TreeMap<String, TreeMap<String, TreeSet<Pagina>>> listaPaginas(){
		return this.listaPaginasValoradas;
	}
	public void listadoTodasWebs(){
		Iterator<String> iterPortal = this.listaPaginasValoradas.keySet().iterator();
		while(iterPortal.hasNext()){
			String portal = iterPortal.next();
			System.out.println("........................."+portal+".........................");
			Iterator<String> iterConsulta = this.listaPaginasValoradas.get(portal).keySet().iterator();
			while(iterConsulta.hasNext()){
				String consulta = iterConsulta.next();
				System.out.println("....."+consulta+".....");
				TreeSet<Pagina> pag = this.listaPaginasValoradas.get(portal).get(consulta);
				Iterator<Pagina> iterPag = pag.iterator();
				while(iterPag.hasNext()){
					Pagina pagAux = iterPag.next();
					System.out.println(pagAux.getTitulo()+" -> "+pagAux.getEnlace());
				}
				System.out.println("\n");
			}
		}
	}
	public String listadoPorRankingConsulta(String consulta){
		String salida="";
		Iterator<String> iterPortal = this.listaPaginasValoradas.keySet().iterator();
		while(iterPortal.hasNext()){
			String portal = iterPortal.next();
			salida+="........................."+portal+".........................\n";
			Iterator<Pagina> iterConsulta = this.listaPaginasValoradas.get(portal).get(consulta).iterator();
			while(iterConsulta.hasNext()){
				Pagina aux = iterConsulta.next();
				if(aux.getConsulta().contains(consulta))
					salida+=aux.rankingToString() +"\n";
			}
		}
		return salida;
	}
	//////////////GUARDAR//////////////
	public void guardarListadoWebs(){
		File archivoEntradas = new File(archivo);
		try {
			PrintWriter pw = new PrintWriter(archivoEntradas);
			
			Iterator<String> iterPortal = this.listaPaginasValoradas.keySet().iterator();
			while(iterPortal.hasNext()){
				String portal = iterPortal.next();
				Iterator<String> iterConsulta = this.listaPaginasValoradas.get(portal).keySet().iterator();
				while(iterConsulta.hasNext()){
					String consulta = iterConsulta.next();
					TreeSet<Pagina> pag = this.listaPaginasValoradas.get(portal).get(consulta);
					Iterator<Pagina> iterPag = pag.iterator();
					while(iterPag.hasNext()){
						Pagina pagAux = iterPag.next();
						
						pw.println(pagAux.toString());
					}
				}
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean agregarPaginaWeb(Pagina paginaNueva){
		if(existe(paginaNueva))
			return false;
		if(this.listaPaginasValoradas.containsKey(paginaNueva.getPortal())){
			if(this.listaPaginasValoradas.get(paginaNueva.getPortal()).containsKey(paginaNueva.getConsulta())){
				return this.listaPaginasValoradas.get(paginaNueva.getPortal()).get(paginaNueva.getConsulta()).add(paginaNueva);
			}
			else{
				TreeSet<Pagina> arrayAux = new TreeSet<Pagina>();
				arrayAux.add(paginaNueva);
				return this.listaPaginasValoradas.get(paginaNueva.getPortal()).put(paginaNueva.getConsulta(), arrayAux) != null;
			}
		}
		else{
			TreeSet<Pagina> arrayAux = new TreeSet<Pagina>();
			arrayAux.add(paginaNueva);
			TreeMap<String, TreeSet<Pagina>> mapAux = new TreeMap<String, TreeSet<Pagina>>();
			mapAux.put(paginaNueva.getConsulta(), arrayAux);
			return this.listaPaginasValoradas.put(paginaNueva.getPortal(), mapAux) != null;
		}
	}
	public boolean existe(Pagina pagina){
		Iterator<String> iterPortal = this.listaPaginasValoradas.keySet().iterator();
		while(iterPortal.hasNext()){
			String portal = iterPortal.next();
			Iterator<String> iterConsulta = this.listaPaginasValoradas.get(portal).keySet().iterator();
			while(iterConsulta.hasNext()){
				String consulta = iterConsulta.next();
				TreeSet<Pagina> pag = this.listaPaginasValoradas.get(portal).get(consulta);
				Iterator<Pagina> iterPag = pag.iterator();
				while(iterPag.hasNext()){
					Pagina pagAux = iterPag.next();
					if(pagina.getEnlace().equals(pagAux.getEnlace()))
							return true;
				}
			}
		}
		return false;
	}
	public boolean addPuntuacion(String enlace, int puntuacion){
		boolean salida = false;
		Iterator<String> iterPortal = this.listaPaginasValoradas.keySet().iterator();
		while(iterPortal.hasNext()){
			String portal = iterPortal.next();
			Iterator<String> iterConsulta = this.listaPaginasValoradas.get(portal).keySet().iterator();
			while(iterConsulta.hasNext()){
				String consulta = iterConsulta.next();
				TreeSet<Pagina> pag = this.listaPaginasValoradas.get(portal).get(consulta);
				Pagina [] array = new Pagina[pag.size()];
				Iterator<Pagina> iterPaginas = pag.iterator();
				int count = 0;
				while(iterPaginas.hasNext()){
					array[count] = iterPaginas.next();
					count++;
				}
				for(int i=0; i<array.length;i++){
					if(enlace.equals(array[i].getEnlace())){
						array[i].addPuntuacionTotal(puntuacion);
						guardarListadoWebs();
						salida = true;
					}
				}
				
				this.listaPaginasValoradas.get(portal).get(consulta).clear();
				
				for(int i=0; i<array.length;i++)
					this.listaPaginasValoradas.get(portal).get(consulta).add(array[i]);
				
			}
		}
		return salida;
	}
}
