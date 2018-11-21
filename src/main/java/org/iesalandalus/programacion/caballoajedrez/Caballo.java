/*
 * Creación de la clase Caballo.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 * @author Emanuel Martínez Lonardi.
 *
 */

public class Caballo {

	private Color color;
	private Posicion posicion;
	
	// Creación del constructor por defecto
	
	public Caballo() {
        this.color = Color.NEGRO;
        this.posicion = new Posicion(8, 'b');
    }	
	
	//Creación de los métodos GET y SET del atributo color.
	public Color getColor() {
        return this.color;
    }
    
    private void setColor(Color color) {
        if (color != null) {
            this.color = color;
        } else {
            throw new NullPointerException("ERROR: el color no puede ser nulo");
        }
    }
    
    // Creación de los métodos GET y SET del atributo posicion.
    public Posicion getPosicion() {
        return this.posicion;
    }
    
    private void setPosicion(Posicion posicion) {
        if (posicion != null) {
            this.posicion = posicion;
        } else {
            throw new NullPointerException("ERROR: la posición no puede ser nula");
        }
    }
    
    // Creamos el construtor para la clase que creará el caballo en dicho color.
    
    public Caballo(Color color) {
    	this.setColor(color);
    	
    	switch (color) {
    	case BLANCO:
    		this.posicion = new Posicion(1, 'b');
    		break;
    	case NEGRO:
    		this.posicion = new Posicion(8, 'b');
    		break;
    	}
    }
}
