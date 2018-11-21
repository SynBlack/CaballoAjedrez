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
    
    /* 
     * Creamos el constructor para la clase que acepte como parámetros el color y columna inicial.
     * La columna inicial debe ser la 'b' o la 'g' y creará un caballo del color dado y colocado en dicha
     * columna y cuya fila será la 1 si es BLANCO y 8 si es NEGRO. 
     */
    
    public Caballo(Color color, char columna) {
    	this.setColor(color);
    	int fila;
    	
    	if (color == Color.BLANCO) {
    		fila = 1;
    	} else {
    		fila = 8;
    	}
    	
    	switch (columna) {
    		case 'b':
    			this.posicion = new Posicion(fila, columna);
    			break;
    		case 'g':
    			this.posicion = new Posicion(fila, columna);
    			break;
    		default:
    			throw new IllegalArgumentException("ERROR: la columna no es correcta.");
    	}
    	
    }
}
