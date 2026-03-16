package jcolonia.daw2025.tablamultiplicar;

import java.util.List;
import java.util.Scanner;

public class VistaGeneral {

	private static String FORMATO_PRINTF_MOSTRARTEXTO = "%s%n";
	private static String FORMATO_PRINTF_MOSTRARAVISO = "[AVISO] %s%n";
	
	static Scanner scEntrada;
	
	
	public static void mostrarTexto(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO,texto);
	}
	
	public static void mostrarAviso(String texto) {
		System.out.printf(FORMATO_PRINTF_MOSTRARAVISO,texto);
	}
	
	public static void mostrarTitulo1(String texto) {
		System.out.printf("== %s ==",texto.toUpperCase());
		System.out.println();
	}
	
	public static void mostrarTitulo2(String texto) {
		System.out.printf("-- %s --",texto);
		System.out.println();
	}
	
	public static int pedirNúmero(String texto) {
		scEntrada = new Scanner(System.in);
		mostrarTexto(texto);
		
		while (!scEntrada.hasNextInt()) {
            mostrarAviso("Por favor, introduce un número válido.");
            scEntrada.nextLine();
        }
        return scEntrada.nextInt();
	}
	
	public static void pausa(String texto) {
		scEntrada = new Scanner(System.in);
		mostrarTexto(texto + " (Pulsa Enter para continuar)");
        scEntrada.nextLine();
	}
	
	public static boolean pedirConfirmacion(String texto) {
        mostrarTexto(texto + " (S/N):");
        String respuesta = scEntrada.next();
        return respuesta.equals("s");
    }
	
	public static void mostrarLista(List<String> lista) {
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    public Scanner getScEntrada() {
        return this.scEntrada;
    }
}
