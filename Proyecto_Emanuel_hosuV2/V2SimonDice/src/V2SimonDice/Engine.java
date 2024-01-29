package V2SimonDice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Emanuel Hosu
 */
public class Engine {
	/**
	 * tColores, un metodo public en el cual generamos el nombre de los colores
	 */
	public enum tColores {
		Rojo, Azul, Verde, Dorado, Blanco, Marron, Naranja
	}
	/**
	 * tModo
	 */
	public enum tModo{
		Facil, Dificil
	}
	/**
	 * MAX_COLORES_SEQ, este es un  metodo static ( por que no nos interesa cambiar su resultado ) el cual se encarga de ponerle un "limite" al secuenciaColores
	 */

	public final int MAX_COLORES_SEQ= 12;
	public final int MAX_COLORES_FACIL= 3;
	public final int MAX_COLORES_DIFICIL = 6;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	/**
	 * charToColor metodo que recibe por parametro un char _color
	 * @param _color este se encarga de poner todos los char introducidos por el usuario en mayusculas y devuelve un color
	 * @return
	 */
	public tColores charToColor(char _color) {
		Scanner scn = new Scanner(System.in);
		
		switch (Character.toUpperCase(_color)) {
		case 'R':
			return tColores.Rojo;
		case 'A':
			return tColores.Azul;
		case 'V':
			return tColores.Verde;
		case 'D':
			return tColores.Dorado;
		case 'B':
			return tColores.Blanco;
		case 'M':
			return tColores.Marron;
		case 'N':
			return tColores.Naranja;
		default:
			System.out.println("Incorrect color...");
			System.out.println("Press ENTER to go to the menu.");
			scn.nextLine();
			mostrarMenu('0');
			return null;
		}
	}
	/**
	 * intToColor, en este metodo se encarga de generar el array
	 * @param _numero parametro que recibe un numero para converirlo en Color,
	 * @return
	 */
	public tColores intToColor(int _numero) {
		Scanner scn = new Scanner(System.in);
		
		switch (Character.toUpperCase(_numero)) {
		case 0:
			return tColores.Rojo;
		case 1:
			return tColores.Azul;
		case 2:
			return tColores.Verde;
		case 3:
			return tColores.Dorado;
		case 4:
			return tColores.Blanco;
		case 5:
			return tColores.Marron;
		case 6:
			return tColores.Naranja;
		default:
			System.out.println("Incorrect color...");
			System.out.println("Press ENTER to go to the menu.");
			scn.nextLine();
			mostrarMenu('0');
			return null;
		}
	}
	/**
	 * 
	 * @param _chosedmode
	 * @return
	 */
	public tModo intToModo(int _chosedmode) {
		switch (Character.toUpperCase(_chosedmode)) {
		case 1:
			return tModo.Facil;
		case 2:
			return tModo.Dificil;
		default:
			return null;
		}
	}
	/**
	 * tModo
	 * @param _modo
	 */
//	public void tModo(int _modo) {
//		if (_modo == 1) {
//			generarSecuencia(3);
//			play();
//			//INTERIOR DEL MODO FAICL
//		}else if (_modo == 2) {
//			generarSecuencia(6);
//			play();
//			//INTERIOR DEL MODO  DIFICIL
//		}
//	}
	/**
	 * generarSecuencia, metodo que se encarga de generar un Array de colores aleatorios en el array secuenciaColores.
	 * @param _numColores este parametro se encarga de recibir el numero de colores que exiten en el array
	 */
	public void generarSecuencia(int _numColores) {
		Random randomColor = new Random();
		
			for (int i = 0; i < secuenciaColores.length; i++) {
				int colorAleatorio = randomColor.nextInt(_numColores + 1); // + 1
				secuenciaColores[i] = intToColor(colorAleatorio);
			}
		
	}
	/**
	 * coprobarColor, metodo que recibe 2 parametros, en este caso un int _index y tColores _color, los cuales los compara y si devuelve true, es que el usuario ha acertado y el juego sigue
	 * @param _index (int del color generado en generarSecuencia)
	 * @param _color (tColores, un parametro introducido por el usuario
	 * @return este returna un true o un false
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		//+2 cada color acertado
		//+5 Si acierta una secuencia
		//-8 si pide ayuda ( pero nunca puede tener valores negativos
		//+40 Si gana el juego
		//Modo dificil la puntuacion es x2 
		Scanner scn = new Scanner(System.in);
		
		if (secuenciaColores[_index] == (_color)) {
			return true;
		}else {
			System.out.println("You failed :(, try again next time");
			System.out.println("Press ENTER to go to the menu.");
			scn.nextLine();
			mostrarMenu('0');
			return false;
		}
	}
	/**
	 * mostrarSecuencia, metodo que recibe un int, que se encarga de enseñar al usuario la copia de un secuenciaColores, pero este con los colores que deseamos que el usuario vea
	 * @param _numero se encarga recibir y mostrar la cantidad de secuencias que salen.
	 */
	public void mostrarSecuencia(int _numero) {
	  	Scanner scn = new Scanner(System.in);

	  		int num_color = _numero + 2;
			tColores[] copiaseq = new tColores[num_color]; //COPIA DE LA SECUENCIA DE COLORES PREVIA, SOLO COLORES QUE QUIERO MOSTRAR
			
			for (int i = 0; i < num_color; i++) {
				copiaseq[i] = secuenciaColores[i];
			}
			System.out.print("\nSequence number " + _numero + ": " + Arrays.toString(copiaseq));
	}
	/**
	 * mostrarMenu metodo que se encarga de mostrar el menu
	 * @param _menu Este metodo se encarga de generar el menú y recibir por consola un numero que este redigira hacia donde lo haya indicado el usuario
	 */
	public void mostrarMenu(char _menu) {
	    Scanner scn = new Scanner(System.in);

	        for (int salto = 0; salto < 10; salto++) {
	            System.out.println();
	        }

	        System.out.println("█▀▄▀█ █▀▀ █▄░█ █░█");
	        System.out.println("█░▀░█ ██▄ █░▀█ █▄█");
	        System.out.println("1. Play");
	        System.out.println("2. How to play");
	        System.out.println("3. Exit");
	        System.out.println("Select option: ");
	        
	        do {
	        	_menu = new Scanner(System.in).next().charAt(0);

	            if (_menu == '1') {
	                for (int salto = 0; salto < 50; salto++) {
	                	System.out.println();
	                }
	                	
	                    System.out.println("Select difficulty: ");
	                    System.out.println("1. Easy mode");
	        	        System.out.println("2. Hard mode");
	        	        System.out.println("3. Back to the menu");
	        	        char playMode = new Scanner(System.in).next().charAt(0);
	        	        
	        	        if (playMode == '1') {
	        	        	//LLEVAR JUGADOR AL MODO FACIL
	        	        	//tModo(1);
	        	        	generarSecuencia(MAX_COLORES_FACIL);
	        	        	play();
	        	        }else if (playMode == '2') {
	        	        	//LLEVAR JUGADOR AL MODO DIFICIL
	        	        	//tModo(2);
	        	        	generarSecuencia(MAX_COLORES_DIFICIL);
	        	        	play();
	        	        }else if (playMode == '3'){
	        	        	mostrarMenu('0');
	        	        }else {
	        	            System.out.println("Entrada no válida. Introduce un número VALIDO del 1 - 3.");
	        	        }
	            } else if (_menu == '2') {
	                for (int salto = 0; salto < 50; salto++) {
	                    System.out.println();
	                }
	                helpMenu();
	            } else if (_menu == '3') {
	                for (int salto = 0; salto < 50; salto++) {
	                    System.out.println();
	                }
	                System.out.println("Good bye :(");
	                System.exit(0);
	            }else {
	            System.out.println("Entrada no válida. Introduce un número VALIDO del 1 - 3.");
	        }
	    } while (_menu < 1 || _menu > 3);
	}
	public boolean usarAyuda(int _index){
		
		
		return true; //pista
	}
	/**
	 * helpMenu que se encarga de ensenyar al usuario como jugar
	 */
	public void helpMenu() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("██╗░░██╗███████╗██╗░░░░░██████╗░");
        System.out.println("██║░░██║██╔════╝██║░░░░░██╔══██╗");
        System.out.println("███████║█████╗░░██║░░░░░██████╔╝");
        System.out.println("██╔══██║██╔══╝░░██║░░░░░██╔═══╝░");
        System.out.println("██║░░██║███████╗███████╗██║░░░░░");
        System.out.println("╚═╝░░╚═╝╚══════╝╚══════╝╚═╝░░░░░");
        
        System.out.println("Bienvenido al apartado de ayuda:");
        System.out.println("Una vez se haya generado la primera secuencia, se te mostrarán 3 colores, los cuales tendrás que memorizar. ");
        System.out.println("el juego pedirá que presiones la tecla ENTER. Una vez presionada, tendrás que introducir de forma individual ");
        System.out.println("los colores y presionar ENTER. A continuación, se le mostrará un ejemplo:");
        System.out.println("Sequence number 1: [Azul, Rojo, Verde]");
        System.out.println("A / a");
        System.out.println("R / r");
        System.out.println("V / v");
        System.out.println("\nUna vez acertada la secuencia, se le mostrará un color más en la secuencia y deberá seguir los mismos pasos.");
        System.out.println("Previamente mencionados. ¡Disfruta al máximo el juego! :D");
        System.out.println("\nPress ENTER to go back to the menu.");
        scn.nextLine();
        
        mostrarMenu('0');
	}
	/**
	 * start Creacion del metodo start, metodo el cual recibe un nombre que llama a la clase Jugador
	 */
	  public void start() {
		  	Scanner scn = new Scanner(System.in);
		  	
	        System.out.println("Welcome to...");
			System.out.println("			  ██");
			System.out.println("			  █░");
			System.out.println("			   ");
			System.out.println("░██████╗██╗███╗░░░███╗░█████╗░███╗░░██╗  ██████╗░██╗░█████╗░███████╗");
			System.out.println("██╔════╝██║████╗░████║██╔══██╗████╗░██║  ██╔══██╗██║██╔══██╗██╔════╝");
			System.out.println("╚█████╗░██║██╔████╔██║██║░░██║██╔██╗██║  ██║░░██║██║██║░░╚═╝█████╗░░");
			System.out.println("░╚═══██╗██║██║╚██╔╝██║██║░░██║██║╚████║  ██║░░██║██║██║░░██╗██╔══╝░░");
			System.out.println("██████╔╝██║██║░╚═╝░██║╚█████╔╝██║░╚███║  ██████╔╝██║╚█████╔╝███████╗");
			System.out.println("╚═════╝░╚═╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝  ╚═════╝░╚═╝░╚════╝░╚══════╝");
			
			System.out.print("\nWhat is your name?" ); // Aqui se instancia el objeto jugador
			Jugador player = new Jugador(scn.nextLine());
			System.out.print(player.getNombre());
			scn.nextLine();
			
			mostrarMenu('0');
	  }
	  		/**
	  		 * play, metodo que se encarga de llamar al método generarSecuencia y al metodo mostrarSecuencia que se encarga de recibir por consola los colores introducidos por el usuario
	  		 * 
	  		 */
			public void play() {
				for (int salto = 0; salto < 50; salto++) {
                    System.out.println();
                }
			  	Scanner scn = new Scanner(System.in);
			  	
    			int i = 1;
    			//int nivel = i + 2;
    			//int modo;
    			//generarSecuencia(0);

    			do {
    				//+5 puntuacion
    				mostrarSecuencia(i);
    				System.out.print("\nMemorize the sequence and press ENTER to continue...");
    				scn.nextLine();
    				for (int salto = 0; salto < 50; salto++) {
    					System.out.println();
    				}
    				
    				int nivel = i + 2;
    				int h = 0;
    				while (h < nivel) {
    					char color_char = new Scanner(System.in).next().charAt(0);
    					tColores color_select = charToColor(color_char);
    					
    					if (comprobarColor(h, color_select) == true) {
    						//+2 puntuacion
    						if (h >= nivel - 1 ) {
    							i++;
    						}
    					}
    					h++;
    				}
    				
    				/*for (int h = 0; h < nivel; h++) {
    					char color_char = new Scanner(System.in).next().charAt(0);
    					tColores color_select = charToColor(color_char);
    					//tColores color_select = intToColor(colorint);
    					//System.out.println(secuenciaColores[h]);
    					
    					if (comprobarColor(h, color_select) == true) {
    						//System.out.println("correcto");
    						if (h >= nivel - 1 ) {
    							i++;
    						}
    					}
    				}*/	
    			}while(i <  secuenciaColores.length - 1 && comprobarColor(i, secuenciaColores[i])); //AND COMBROBAR COLOOR RETURN TRUE
    			
    			System.out.println("Congratulations :D. You won the game");
    			System.out.println("Press ENTER to go to the menu.");
    			scn.nextLine();
    			mostrarMenu('0');
	  }
}
