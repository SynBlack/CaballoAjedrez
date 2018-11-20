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
            throw new IllegalArgumentException("ERROR: Fila no v�lida.");
        }

    }
    
    /*
     * Creamos el get y set columna
     */
    public char getColumna() {
        return this.columna;
    }
    
    
    public void setColumna(char columna) {
        String letras = "abcdefgh";
        boolean letraValida = false;

        for (int i = 0; i < letras.length(); i++) {
            if (columna == letras.charAt(i)) {
                letraValida = true;
            }
        }
        if (letraValida) {
            this.columna = columna;
        } else {
            throw new IllegalArgumentException("ERROR: Columna no v�lida.");
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

    /*
     * Creamos el constructor copia.
     */
    public Posicion(Posicion posicion) {
        if (posicion != null) {
        this.setFila(posicion.fila);
        this.setColumna(posicion.columna);
        } else {
            throw new NullPointerException("ERROR: No es posible copiar una posici�n nula.");
        }
    }
    
    /*
     * Creaci�n del m�todo equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Posicion)) { 
            return false;
        }
        Posicion other = (Posicion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }
}