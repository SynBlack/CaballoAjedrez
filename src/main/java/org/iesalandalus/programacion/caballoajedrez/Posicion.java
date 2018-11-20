/**
 * Creación de la clase Posición
 */

package org.iesalandalus.programacion.caballoajedrez;

/**
 * @author Emanuel Martínez Lonardi
 *
 */
public class Posicion {
	private int fila;
	private char columna;

/**
 * Primero creamos el getFila.
 * Devolverá un entero entre 1 y 8.
 */
public int getFila() {
    return fila;
}

/**
 * Creamos el getColumna.
 * Devolverá un carácter entre a y h.
 */
public char getColumna() {
    return columna;
}

/**
 * Creamos el método setFila con una comprobación de valor.
 */
public void setFila(int fila) {
    if (fila >= 1 && fila <= 8) {
        this.fila = fila;
    } else {
    	throw new IllegalArgumentException("ERROR: Fila incorrecta.");
    }
}

/**
 * Creamos el método setColumna con una comprobación de valor.
 */
public void setColumna(char columna) {
    if (columna >= 97 && columna <= 104) {
        this.columna = columna;
    } else {
    	throw new IllegalArgumentException("ERROR: Columna incorrecta.");
    }
}
}
