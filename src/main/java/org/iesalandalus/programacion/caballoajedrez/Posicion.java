/**
 * Creaci�n de la clase Posici�n
 */

package org.iesalandalus.programacion.caballoajedrez;

/**
 * @author Emanuel Mart�nez Lonardi
 *
 */
public class Posicion {
	private int fila;
	private char columna;

/**
 * Primero creamos el getFila.
 * Devolver� un entero entre 1 y 8.
 */
public int getFila() {
    return fila;
}

/**
 * Creamos el getColumna.
 * Devolver� un car�cter entre a y h.
 */
public char getColumna() {
    return columna;
}

/**
 * Creamos el m�todo setFila con una comprobaci�n de valor.
 */
public void setFila(int fila) {
    if (fila >= 1 && fila <= 8) {
        this.fila = fila;
    } else {
    	throw new IllegalArgumentException("ERROR: Fila incorrecta.");
    }
}

/**
 * Creamos el m�todo setColumna con una comprobaci�n de valor.
 */
public void setColumna(char columna) {
    if (columna >= 97 && columna <= 104) {
        this.columna = columna;
    } else {
    	throw new IllegalArgumentException("ERROR: Columna incorrecta.");
    }
}
}
