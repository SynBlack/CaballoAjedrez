/*
 * Creación de la clase Caballo.
 */
package org.iesalandalus.programacion.caballoajedrez;

// Importamos la excepción para que funcione.
import javax.naming.OperationNotSupportedException;

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

	// Creación de los métodos GET y SET del atributo color.
	public Color getColor() {
		return this.color;
	}

	private void setColor(Color color) {
		if (color != null) {
			this.color = color;
		} else {
			throw new NullPointerException("ERROR: el color no puede ser nulo.");
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
			throw new NullPointerException("ERROR: la posición no puede ser nula.");
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
	 * Creamos el constructor para la clase que acepte como parámetros el color y
	 * columna inicial. La columna inicial debe ser la 'b' o la 'g' y creará un
	 * caballo del color dado y colocado en dicha columna y cuya fila será la 1 si
	 * es BLANCO y 8 si es NEGRO.
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

	/*
	 * Crear método mover que modificará la posición del mismo o, si no puede hacer
	 * ese movimiento, lance una excepción y que no modifique la posición del
	 * caballo.
	 */

	public void mover(Direccion direccion) throws OperationNotSupportedException {
		String letras = "abcdefgh";
		boolean movimientoValido = false;
		int fila = this.posicion.getFila();
		int columna = 0;

		for (int i = 1; i <= letras.length(); i++) {
			if (this.posicion.getColumna() == letras.charAt(i)) {
				columna = i;
			}
		}

		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			columna = columna + 2;
			fila = fila - 1;
			break;
		case ARRIBA_DERECHA:
			columna = columna + 2;
			fila = fila + 1;
			break;
		case DERECHA_ARRIBA:
			columna = columna + 1;
			fila = fila + 2;
			break;
		case DERECHA_ABAJO:
			columna = columna - 1;
			fila = fila + 2;
			break;
		case ABAJO_DERECHA:
			columna = columna - 2;
			fila = fila + 1;
			break;
		case ABAJO_IZQUIERDA:
			columna = columna - 2;
			fila = fila - 1;
			break;
		case IZQUIERDA_ARRIBA:
			columna = columna + 1;
			fila = fila - 2;
			break;
		case IZQUIERDA_ABAJO:
			columna = columna - 1;
			fila = fila - 2;
			break;
		default:
			System.err.println("Ese movimiento no es válido, vuelva a intentarlo.");
		}

		if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		} else {
			System.out.println("El movimiento ha sido válido y correcto.");
		}
	}
	
	/*
	 * Creación del método equals, sobreescribiendo también el hashCode, para comparar la igualdad de los 
	 * objetos de la clase.
	 */
	
	@Override
    public int hashCode() {
        final int prime = 13;
        int result = 1;
        int colorInt;
        if (color == Color.BLANCO) {
            colorInt = 7;
        } else {
            colorInt = 9;
        }
        result = prime * result + colorInt;
        result = prime * result + this.posicion.getFila();
        result = prime * result + this.posicion.getColumna();
        return result;
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Caballo)) {
            return false;
        }
        Caballo other = (Caballo) obj;
        if (this.color != other.color) {
            return false;
        }
        if (this.posicion.getFila() != other.posicion.getFila()) {
            return false;
        }
        if (this.posicion.getColumna() != other.posicion.getColumna()) {
            return false;
        }
        return true;
    }
     
     /*
      * Crear método toString que devuelva un String que será la representación de dicho objeto (color y posición).
      */
     
     @Override
     public String toString() {
         return "Caballo [posición=[fila=" + this.posicion.getFila() + ", columna=" + this.posicion.getColumna() + "], color=" + this.color + "]";
     }
}
