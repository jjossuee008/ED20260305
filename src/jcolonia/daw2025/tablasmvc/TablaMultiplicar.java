package jcolonia.daw2025.tablamultiplicar;

import java.util.ArrayList;
import java.util.List;

/**
 * Aplicacion que genera tablas de multiplicar y permite realizar distintas opciones con esta
 */
public class TablaMultiplicar {

	/** Numero que se usara en las tablas */
	private int numero;
	/** Almacen donde se encontraran las tablas completas */
	private List<String> listaTextos;
	
	/** Constructor principal 
	 *  @param numero que se usara para las tablas.
	 * */
	public TablaMultiplicar(int numero) {
		this.numero = numero;
		this.listaTextos = new ArrayList<>();
	}
	
	/** 
	 * Genera la tabla a partir del numero indicado.
	 */
	public void generarTabla(){
		String calculo;
		for(int a = 0; a < 10; a++) {
			calculo = String.format("%d X %d = %d",numero,a,numero * a);
			this.listaTextos.add(calculo);
		}
	}
	
	/**
     * Obtiene la lista de multiplicaciones formateada para su almacenamiento externo.
     * Este método se utiliza cuando se desea guardar la tabla en archivos (TXT, CSV, etc.).
     * * @return Una lista de cadenas de texto optimizada para exportación.
     */
    public List<String> toListaExportacion() {
        return this.listaTextos;
    }

    /**
     * Obtiene la lista de multiplicaciones preparada para ser visualizada por el usuario.
     * Ideal para mostrar el contenido en consolas, etiquetas de interfaz gráfica o vistas web.
     * * @return Una lista de cadenas de texto listas para mostrar en pantalla.
     */
    public List<String> toListaPantalla() {
        return this.listaTextos;
    }
	
    /**
    * @return Representación textual completa de la tabla con saltos de línea.
    */
	@Override
	public String toString() {
		if (listaTextos.isEmpty()) {
            return "La tabla del " + numero + " aún no ha sido generada.";
        }
        return String.join("\n", listaTextos);
	}
}
