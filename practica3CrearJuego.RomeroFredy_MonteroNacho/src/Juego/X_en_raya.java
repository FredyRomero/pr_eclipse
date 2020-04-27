package Juego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class X_en_raya {
static Scanner tec = new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("HOla10");
		System.out.println("Es el juego de X En Raya");
		System.out.println("-----------------------");
		int opcion;

		do {
			opcion = elegirOpcionMenu();
			switch (opcion) {
			case 1:
				opcion1();
				break;
			case 2:
				System.out.println("Fin del juego");
				break;
			}
		} while (opcion != 2);

	}

	public static int elegirOpcionMenu() {
		System.out.println("-----------------------");
		System.out.println("Selecciona: ");
		System.out.println(" 1. Jugar");
		System.out.println(" 2. Salir");
		System.out.println("-----------------------");
		int volver = 0;
		try {
			volver = tec.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("No es un numero");
		}
		tec.nextLine();
		if (volver < 0 || volver > 2) {
			System.out.println("***Introduce opcion correcta***");
			return volver;
		} else {
			return volver;
		}

	}

public static void opcion1() {
		char J1 = 'X';
		char J2 = 'O';
		char vacio = '-';

	boolean turno = true;

		int tamanyo = 0;

		do {
			try {
				System.out.println("Indica el tamanyo del tablero");
				tamanyo = tec.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("No es un numero");

			} catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
				System.out.println();
				System.out.println("Tamanyo Icorrecto");

			} catch (NegativeArraySizeException e) {
				System.out.println();
				System.out.println("No se permite negativos");

			}

			tec.nextLine();

		} while (tamanyo <= 2 || tamanyo > 9);

		char[][] tablero = new char[tamanyo][tamanyo];
		rellenarTabla(tablero, vacio);

		int fila = 0, columna = 0;
		boolean posValida, correcto;
		int ficha1 = tamanyo;
		int ficha2 = tamanyo;
		boolean lo;

		do {
			do {
				mostrarTurnoActual(turno);
				mostrarTablero(tablero);
				correcto = false;
				do {
					try {
						System.out.println("Dame Posicion\nSepara el Numero de la Letra");
						fila = pedirFila();
						columna = pedirColumna();
						lo = true;
					} catch (InputMismatchException e) {
						lo = false;
						System.out.println("Introduce Posicion Valida");
						mostrarTablero(tablero);
					}

					tec.nextLine();
				} while (!lo);

				posValida = validarPosicion(tablero, fila, columna);

				if (posValida) {
					if (!hayValor(tablero, fila, columna, vacio)) {
						correcto = true;
					} else {
						System.out.println("Posicion Ocupada");
					}
				} else {
					System.out.println("Posicion no Valida");

				}

			} while (!correcto);

			if (turno) {
				insertarValor(tablero, fila, columna, J1);
				System.out.println("Tienes " + ficha1 + " Fichas");
				ficha1 = ficha1 - 1;
			} else {
				insertarValor(tablero, fila, columna, J2);
				System.out.println("Tienes " + ficha2 + " Fichas");
				ficha2 = ficha2 - 1;
			}

			turno = !turno;

		} while (!finPartida(tablero, vacio) && ficha2 > 0);
		mostrarTablero(tablero);
		mostrarGanador(tablero, J1, J2, vacio, fila, columna, turno, posValida, correcto);

	}

	public static int pedirColumna() {

		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "�", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		String le = tec.next();

		int pos = 0;
		String letra = le.substring(le.length() - 1);
		letra = letra.toUpperCase();

		for (int i = 0; i < letras.length; i++) {
			if (letras[i].equals(letra)) {
				pos = i;
			}
		}

		return pos;
	}

	public static int pedirFila() {

		int fila = tec.nextInt();

		return fila - 1;
	}

	public static void rellenarTabla(char[][] matriz, char simbolo) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = simbolo;
			}
		}

	}

	public static void mostrarTablero(char matriz[][]) {
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		System.out.print("  ");
		for (int i = 0; i < matriz[0].length; i++) {
			System.out.print(letras[i] + " ");
		}
		System.out.println();
		for (int j = 0; j < matriz.length; j++) {
			System.out.print((j + 1) + " ");
			for (int i = 0; i < matriz[0].length; i++) {
				System.out.print(matriz[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static boolean validarPosicion(char[][] matriz, int fila, int columna) {
		if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz.length) {
			return true;
		}
		return false;
	}

	public static void mostrarTurnoActual(boolean turno) {
		if (turno) {
			System.out.println("Le toca al Jugador 1");

		} else {
			System.out.println("Le toca al Jugador 2");

		}
	}

	public static boolean hayValor(char[][] matriz, int fila, int columna, char simbolo) {
		if (matriz[fila][columna] != simbolo) {
			return true;
		}
		return false;

	}

	public static void insertarValor(char[][] matriz, int fila, int columna, char simbolo) {

		matriz[fila][columna] = simbolo;

	}

	public static boolean matrizLlena(char[][] matriz, char simbolo) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == simbolo) {
					return false;
				}
			}

		}
		return true;
	}

	public static boolean finPartida(char[][] matriz, char simbolo) {

		if (horizontal(matriz, simbolo) != simbolo || vertical(matriz, simbolo) != simbolo
				|| diagonal(matriz, simbolo) != simbolo || diagonal2(matriz, simbolo) != simbolo) {

			return true;
		}
		return false;
	}

	public static char horizontal(char[][] matriz, char simbolo) {

		char simbolo1;
		boolean enc;
		for (int i = 0; i < matriz.length; i++) {
			enc = true;
			simbolo1 = matriz[i][0];

			if (simbolo1 != simbolo) {
				for (int j = 1; j < matriz[0].length; j++) {

					if (simbolo1 != matriz[i][j]) {
						enc = false;
					}
				}

				if (enc) {
					return simbolo1;
				}
			}

		}

		return simbolo;

	}

	public static char vertical(char[][] matriz, char simbolo) {
		char simbolo1;
		boolean enc;
		for (int j = 0; j < matriz.length; j++) {
			enc = true;
			simbolo1 = matriz[0][j];

			if (simbolo1 != simbolo) {
				for (int i = 1; i < matriz[0].length; i++) {

					if (simbolo1 != matriz[i][j]) {
						enc = false;
					}
				}

				if (enc) {
					return simbolo1;
				}
			}

		}

		return simbolo;

	}

	public static char diagonal(char[][] matriz, char simbolo) {

		char simbolo1;
		boolean enc = true;

		// diagonal izquirda arriba, derecha abajo
		simbolo1 = matriz[0][0];
		if (simbolo1 != simbolo) {
			for (int i = 0; i < matriz.length; i++) {

				if (simbolo1 != matriz[i][i]) {
					enc = false;
				}
			}
			if (enc) {
				return simbolo1;
			}
		}
		return simbolo;
	}

	public static char diagonal2(char[][] matriz, char simbolo) {
		char simbolo1;
		boolean enc = true;

		// diagonal, derecha arriba, izquierda abajo
		simbolo1 = matriz[0][matriz.length - 1];
		if (simbolo1 != simbolo) {
			for (int i = 1, j = 1; i < matriz.length; i++, j--) {

				if (simbolo1 != matriz[i][j]) {
					enc = false;
				}
			}
			if (enc) {
				return simbolo1;
			}
		}

		return simbolo;

	}

	public static void mostrarGanador(char[][] matriz, char J1, char J2, char simbolo, int fila, int columna,
			boolean turno, boolean posValida, boolean correcto) {

		char simbolo1 = horizontal(matriz, simbolo);
		if (simbolo1 != simbolo) {
			if (simbolo1 == J1) {
				System.out.println("Ha Ganado el Jugador 1 en horizontal");
			} else {
				System.out.println("Ha Ganado el Jugador 2 en horizontal");
			}
			return;
		}

		simbolo1 = vertical(matriz, simbolo);
		if (simbolo1 != simbolo) {
			if (simbolo1 == J1) {
				System.out.println("Ha Ganado el Jugador 1 en vertical");
			} else {
				System.out.println("Ha Ganado el Jugador 2 en vertical");
			}
			return;
		}

		simbolo1 = diagonal(matriz, simbolo);
		if (simbolo1 != simbolo) {
			if (simbolo1 == J1) {
				System.out.println("Ha Ganado el Jugador 1 en diagonal");
			} else {
				System.out.println("Ha Ganado el Jugador 2 en diagonal");
			}
			return;
		}

		simbolo1 = diagonal2(matriz, simbolo);
		if (simbolo1 != simbolo) {
			if (simbolo1 == J1) {
				System.out.println("Ha Ganado el Jugador 1 en diagonal inversa");
			} else {
				System.out.println("Ha Ganado el Jugador 2 en diagonal inversa");
			}
		} else {
			// return;
			irFase2(matriz, fila, columna, turno, posValida, correcto, J1, J2);
		}

	}

	public static void irFase2(char[][] matriz, int fila, int columna, boolean turno, boolean posValida,
			boolean correcto, char J1, char J2) {
		System.out.println("No Quedan Fichas | Pasando a Fase 2");

		char vacio = '-';
		boolean posFicha = false, lo;

		do {
			do {
				mostrarTurnoActual(turno);
				mostrarTablero(matriz);
				correcto = false;
				do {
					try {
						System.out.println("Seleciona Ficha a Mover");
						fila = pedirFila();
						columna = pedirColumna();
						posFicha = validarFichaMover(matriz, fila, columna, turno, J1, J2);
						posValida = validarPosicion(matriz, fila, columna);
						lo = true;
					} catch (InputMismatchException e) {
						lo = false;
						System.out.println("Introduce Posicion Valida");
						mostrarTablero(matriz);
					} catch (ArrayIndexOutOfBoundsException e) {
						lo = false;
						System.out.println("Introduce Posicion Valida");
						mostrarTablero(matriz);
					}

					tec.nextLine();
				} while (!lo);

				if (posValida) {
					if (posFicha) {
						insertarValor(matriz, fila, columna, vacio);
						correcto = true;
					} else {
						System.out.println("No es tu Ficha");
					}
				} else {
					System.out.println("Posicion Invalida");
				}
			} while (!correcto);

			do {
				mostrarTurnoActual(turno);
				mostrarTablero(matriz);
				correcto = false;
				do {
					try {
						System.out.println("Seleciona Donde Mover");
						fila = pedirFila();
						columna = pedirColumna();
						lo = true;
					} catch (InputMismatchException e) {
						lo = false;
						System.out.println("Introduce Posicion Valida");
						mostrarTablero(matriz);
					} catch (ArrayIndexOutOfBoundsException e) {
						lo = false;
						System.out.println("Introduce Posicion Valida");
						mostrarTablero(matriz);
					}

					tec.nextLine();
				} while (!lo);

				if (posValida) {
					if (!hayValor(matriz, fila, columna, vacio)) {

						correcto = true;
					} else {
						System.out.println("Posicion Ocupada");
					}
				} else {
					System.out.println("Posicion no Valida");
				}
			} while (!correcto);

			if (turno) {
				insertarValor(matriz, fila, columna, J1);
			} else {
				insertarValor(matriz, fila, columna, J2);
			}

			turno = !turno;

		} while (!finPartida(matriz, vacio));
		mostrarTablero(matriz);

		mostrarGanador(matriz, J1, J2, vacio, fila, columna, turno, posValida, correcto);

	}

	public static boolean validarFichaMover(char[][] matriz, int fila, int columna, boolean turno, char J1, char J2) {
		if (turno && matriz[fila][columna] == J1) {
			return true;
		} else {
			if (!turno && matriz[fila][columna] == J2)
				return true;
		}

		return false;

	}

}
