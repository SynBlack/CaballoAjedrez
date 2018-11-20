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

    /*
     * Creamos el get y set fila
     */
    public int getFila() {
        return this.fila;
    }
    
    public void setFila(int fila) {

        if (fila >= 1 && fila <= 8) {
            this.fila = fila;
        } else {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }

    }
    
    /*
     * Creamos el get y set columna
     */
    public char getColumna() {
        return this.columna;
    }
    
    
    public void setColumna(char columna) {
        String letras = "aAbBcCdDeEfFgGhH";
        boolean letraValida = false;

        for (int i = 0; i < letras.length(); i++) {
            if (columna == letras.charAt(i)) {
                letraValida = true;
            }
        }
        if (letraValida) {
            this.columna = columna;
        } else {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
    }
    
    /**
     * Iniciamos los atributos fila y columna
     *
     */
    public Posicion(int fila, char columna) {
        this.setFila(fila);
        this.setColumna(columna);
    }

}