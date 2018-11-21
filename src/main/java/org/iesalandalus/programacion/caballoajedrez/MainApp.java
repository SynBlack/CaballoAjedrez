/*
 * Método main de ejecución de nuestro programa.
 */

/**
 * @author Emanuel Martínez Lonardi
 */

package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Caballo caballo;

	public MainApp() {
		caballo = null;
	}

	public static void main(String[] args) {
		mostrarMenu();

	}

	private static void mostrarMenu() {

		int opcion = 5;

		do {
			System.out.println("");
			System.out.println("Menú de opciones:");
			System.out.println("1 = Crear caballo por defecto");
			System.out.println("2 = Crear caballo de un color");
			System.out.println("3 = Crear caballo de un color en columna inicial");
			System.out.println("4 = Mover caballo");
			System.out.println("0 = Salir");

			opcion = elegirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion >= 0 && opcion <= 4);
	}

	private static int elegirOpcion() {

		int opcion = 5;

		do {
			System.out.print("Eliga una de las siguientes opciones: ");
			opcion = Entrada.entero();
		} while (opcion < 0 || opcion > 4);

		return opcion;
	}

	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 0:
			System.exit(0);
			break;
		case 1:
			crearCaballoDefecto();
			mostrarMenu();
			break;
		case 2:
			crearCaballoDefectoColor();
			mostrarMenu();
			break;
		case 3:
			crearCaballoColorPosicion();
			mostrarMenu();
			break;
		case 4:
			if (caballo == null) {
				System.out.println("¡No tan deprisa, debes crear un caballo primero!");
				mostrarMenu();
			} else {
				mostrarMenuDirecciones();
			}
			break;
		}
	}

	private static void crearCaballoDefecto() {

		caballo = new Caballo();
		System.out.println(caballo);
	}

	private static void crearCaballoDefectoColor() {

		Color color = elegirColor();
		caballo = new Caballo(color);
		System.out.println(caballo);
	}

	private static Color elegirColor() {

		int opcion = 0;
		do {
			System.out.println("Elige un color: 1 = BLANCO, 2 = NEGRO");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 2);

		if (opcion == 1) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}

	private static void crearCaballoColorPosicion() {

		Color color = elegirColor();
		char columna = elegirColumnaInicial();

		caballo = new Caballo(color, columna);
		System.out.println(caballo);
	}

	private static char elegirColumnaInicial() {

		int columna;
		do {
			System.out.println("Elige una columna: 1 = b, 2 = g");
			columna = Entrada.entero();
		} while (columna < 1 || columna > 2);

		if (columna == 1) {
			return 'b';
		} else {
			return 'g';
		}
	}

	private static void mover() {

		Direccion direccion = null;

		try {

			do {
				direccion = elegirDireccion();
			} while (direccion == null);

			caballo.mover(direccion);
			System.out.println(caballo);

		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
		mover();
	}

	private static void mostrarMenuDirecciones() {

		System.out.println("");
		System.out.println("Menú de direcciones:");
		System.out.println("1 = ARRIBA_IZQUIERDA");
		System.out.println("2 = ARRIBA_DERECHA");
		System.out.println("3 = DERECHA_ARRIBA");
		System.out.println("4 = DERECHA_ABAJO");
		System.out.println("5 = ABAJO_DERECHA");
		System.out.println("6 = ABAJO_IZQUIERDA");
		System.out.println("7 = IZQUIERDA_ARRIBA");
		System.out.println("8 = IZQUIERDA_ABAJO");
		System.out.println("9 = Mostrar el menú direcciones.");
		System.out.println("0 = Volver al menú principal.");

		mover();
	}

	private static Direccion elegirDireccion() {

		boolean valida = false;
		Direccion direccion = null;
		int opcion = 10;
		do {
			System.out.print("Elige una dirección a la que mover el caballo:");
			opcion = Entrada.entero();
		} while (opcion < 0 || opcion > 9);

		switch (opcion) {
		case 1:
			direccion = Direccion.ARRIBA_IZQUIERDA;
			break;
		case 2:
			direccion = Direccion.ARRIBA_DERECHA;
			break;
		case 3:
			direccion = Direccion.DERECHA_ARRIBA;
			break;
		case 4:
			direccion = Direccion.DERECHA_ABAJO;
			break;
		case 5:
			direccion = Direccion.ABAJO_DERECHA;
			break;
		case 6:
			direccion = Direccion.ABAJO_IZQUIERDA;
			break;
		case 7:
			direccion = Direccion.IZQUIERDA_ARRIBA;
			break;
		case 8:
			direccion = Direccion.IZQUIERDA_ABAJO;
			break;
		case 9:
			mostrarMenuDirecciones();
			break;
		case 0:
			mostrarMenu();
			break;
		}

		valida = comprobarMovimiento(direccion);
		if (valida == false) {
			direccion = null;
		}

		return direccion;
	}

	private static boolean comprobarMovimiento(Direccion direccion) {
		Posicion posicion = null;
		posicion = caballo.getPosicion();
		String letras = "abcdefgh";
		int fila = posicion.getFila();
		int columna = 0;

		for (int i = 0; i < letras.length(); i++) {
			if (posicion.getColumna() == letras.charAt(i)) {
				columna = i + 1;
			}
		}

		if (direccion == null) {
			throw new NullPointerException("ERROR: la dirección no puede ser nula");
		} else {
			switch (direccion) {
			case ARRIBA_IZQUIERDA:
				columna = columna - 1;
				fila = fila + 2;
				break;
			case ARRIBA_DERECHA:
				columna = columna + 1;
				fila = fila + 2;
				break;
			case DERECHA_ARRIBA:
				columna = columna + 2;
				fila = fila + 1;
				break;
			case DERECHA_ABAJO:
				columna = columna + 2;
				fila = fila - 1;
				break;
			case ABAJO_DERECHA:
				columna = columna + 1;
				fila = fila - 2;
				break;
			case ABAJO_IZQUIERDA:
				columna = columna - 1;
				fila = fila - 2;
				break;
			case IZQUIERDA_ARRIBA:
				columna = columna - 2;
				fila = fila + 1;
				break;
			case IZQUIERDA_ABAJO:
				columna = columna - 2;
				fila = fila - 1;
				break;
			}
		}

		if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
			System.out.println("Movimiento incorrecto, inténtalo de nuevo.");
			return false;
		} else {
			return true;
		}

	}

}
