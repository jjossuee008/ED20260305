package jcolonia.daw2025.menú;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Ejercicio de prueba que simula el funcionamiento de la creacion de un menu.
 * Posteriormente se indicara que se seleccione una de las opciones.
 * 
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (24022026)
 */
public class VistaMenú {
	
	/** Titulo que tendra el menu */
	private String titulo;
	/** Almacen que guarda las opciones que se le indican */
	private List<String> opciones;
	/** Captara los datos introducidos por el usuario */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Creara el menu con el titulo y opciones indicados.
	 * 
	 * @param titulo del menu
	 * @param opciones lista de opciones.
	 */
	public VistaMenú(String titulo, List<String> opciones) {
		this.titulo = titulo;
		this.opciones = new ArrayList<>();
		
		for(String s: opciones) {
			this.opciones.add(s);
		}
	}
	
	/**
	 * Muestra el titulo indicado.
	 */
	public void mostrarTitulo() {
		int longitudTitulo = titulo.length();
		
		System.out.println(titulo);
		
		for(int a = 0; a < longitudTitulo; a++) {
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	/** 
	 * Muestra las diferentes opciones guardadas en el almacen.
	 */
	public void mostrarOpciones() {
		for(int a = 0; a < opciones.size(); a++) {
			System.out.printf("%d) opción %s\n", a + 1, opciones.get(a));
		}
	}

	/**
	 * Pide una de las opciones disponible.
	 * 
	 * @return opcion deseada
	 * @throws RuntimeException si se pide una opciones que no se encuentra en la lista.
	 */
	public int pedirOpción() {
		int opcionElegida;
		
		opcionElegida = sc.nextInt();
		
		if(opcionElegida > opciones.size()) {
			throw new RuntimeException("Elige una opciones correcta");
		}
		
		System.out.println("Indica una de las opciones");
		
		return opcionElegida;
	}
	
	/**
	 * Muestra el texto deseado.
	 * @param texto indicado.
	 * @return texto
	 */
	public String mostrarTexto(String texto) {
		return texto;
	}
}
