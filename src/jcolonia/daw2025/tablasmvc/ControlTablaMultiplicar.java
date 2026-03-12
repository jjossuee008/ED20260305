package jcolonia.daw2025.tablamultiplicar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jcolonia.daw2025.menú.*;

/**
* Núcleo de aplicación de consola de texto con menús. Aplicación
* de texto usando tablas de multiplicar infantiles clásicas. 
*/
public class ControlTablaMultiplicar {
	/** Formato tipo «printf» para el nombre del archivo de
	* exportación.
	*/
	public static final String FORMATO_RUTA_ARCHIVO_EXPORTACIÓN=
		"tabla del %02d.txt";
	
	/** Tabla de multiplicar activa. */
	private TablaMultiplicar tabla;
	
	private int numeroActivo;
	
	/** Lista con los textos de las opciones del menú. */
	private static final List<String> OPCIONES_MENÚ_PRINCIPAL = new ArrayList<>();

	static {
	    OPCIONES_MENÚ_PRINCIPAL.add("Mostrar tabla activa");
	    OPCIONES_MENÚ_PRINCIPAL.add("Cambiar tabla (nuevo número)");
	    OPCIONES_MENÚ_PRINCIPAL.add("Exportar tabla a archivo");
	    OPCIONES_MENÚ_PRINCIPAL.add("Salir");
	}
	
	/** constructor principal de ControlTablaMultiplicar */
	public ControlTablaMultiplicar(){
		init();
	}


	/**
	* Pide al usuario un número y prepara la primera
	* tabla activa.
	*/
	public void init(){
		cambiarTabla();
	}

	/**
	* Gestión del menú principal. Desde este menú
	* se ejecutan las opciones disponibles a elección del usuario.
	* A la salida del menú se finaliza el programa.
	 * @throws EscepcíonES lanzara un error al no detectar una tabla
	*/
	public void buclePrincipal() { 
	    VistaMenú menú = new VistaMenú("Tablas de multiplicar", OPCIONES_MENÚ_PRINCIPAL);
	    int opción = -1; 
	    
	    do {
	        try {
	            menú.mostrarOpciones();
	            opción = menú.pedirOpción(); 
	            
	            switch(opción) {
	                case 1:
	                	mostrarTabla();
	                	break;
	                case 2:
	                	cambiarTabla();
	                	break;
	                case 3:
	                	exportarTabla();
	                	break;
	                case 0: // SALIR
	                	break;
	                default:
	                    opciónNoDisponible();
	                    break;
	            }
	        } catch (EscepcíonES e) {
	            opciónNoDisponible(); 
	            VistaGeneral.mostrarAviso(e.getLocalizedMessage());
	        }
	    } while (opción != 0);
	    
	    VistaGeneral.mostrarAviso("FIN");
	}
	
	/**
	* Muestra por pantalla -envía a la salida estándar-
	* los productos correspondientes a la tabla activa.
	 * @throws EscepcíonES lanzara un error al no detectar una tabla
	*/
	private void mostrarTabla() throws EscepcíonES{
		if(tabla == null) {
			throw new EscepcíonES("No se ha indicado ninguna tabla");
		}
		
		
		VistaGeneral.mostrarTitulo1("Tabla del "+ numeroActivo);
		List<String> lineas;
		
		lineas = tabla.toListaPantalla();
		VistaGeneral.mostrarLista(lineas);
		VistaGeneral.pausa("Pulsa Enter para continuar");
		
	}
	
	/**
	* Cambia la tabla activa por otra elegida por el usuario.
	*/
	private void cambiarTabla(){
		int n;
	 
	    
	    System.out.println("Introduzca el número para la tabla:");
	    
	    Scanner scEntrada = new Scanner(System.in); 
	    n = scEntrada.nextInt();
	    this.numeroActivo = n;
	    scEntrada.nextLine();
	    
	    tabla = new TablaMultiplicar(n);
	    tabla.generarTabla();
	    
	    VistaGeneral.mostrarAviso("Tabla del " + n + " preparada.");
	}

	/**
	 * Envía a un archivo los productos correspondientes a la tabla activa.
	 */
	private void exportarTabla() {

	    String nombreArchivo = String.format(FORMATO_RUTA_ARCHIVO_EXPORTACIÓN, this.numeroActivo);
	    
	    List<String> lineas = tabla.toListaExportacion();
	    
	    try (java.io.PrintWriter escritor = new java.io.PrintWriter(nombreArchivo)) {
	        for (String linea : lineas) {
	            escritor.println(linea);
	        }
	        VistaGeneral.mostrarAviso("Archivo exportado con éxito: " + nombreArchivo);
	        
	    } catch (java.io.FileNotFoundException e) {
	        VistaGeneral.mostrarAviso("Error al crear el archivo: " + e.getMessage());
	    }
	}
	
	/**
	 * Muestra un mensaje de aviso indicando que 
	 * la opción elegida no está disponible.
	*/
	private void opciónNoDisponible(){
		VistaGeneral.mostrarAviso("La opcion indicada no esta disponible");
	}




}
