package SimonDiceV3;

import java.io.IOException;
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
	 * tModo este es un metodo que se encarga de devolvernos el modo del juego, si este es facil la puntuacion se multiplicara en el metodo play en * 1 y si esta en el modo dificil en el metodo play se multiplicara * 2 
	 */
	public enum tModo{
		Facil, Dificil
	}

	public final int MAX_COLORES_SEQ= 15;
	public final int MAX_COLORES_FACIL= 3;
	public final int MAX_COLORES_DIFICIL = 6;
	public int pistas = 3;
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
			return null;
		}
	}
	/**
	 * intToColor, en este metodo se encarga de generar el array, metodo que tiene 7 colores, 4 para el modo facil y 7 para el mmodo dificl
	 * @param _numero parametro que recibe un numero para converirlo en Color,
	 * @return
	 */
	public tColores intToColor(int _numero) {
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
			return null;
		}
	}
	/**
	 * intToModo un modo añadido por mi, este lo utilizo en el menu recibiendo un int y devolviendo el metodo para que lo reciba el play()
	 * @param _chosedmode recibe un int
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
		Scanner scn = new Scanner(System.in);
		
		if (secuenciaColores[_index] == (_color)) {
			return true;
		}else {
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
	 */
	public void mostrarMenu() {
	    Scanner scn = new Scanner(System.in);

	        for (int salto = 0; salto < 50; salto++) {
	            System.out.println();
	        }

	        System.out.println("█▀▄▀█ █▀▀ █▄░█ █░█");
	        System.out.println("█░▀░█ ██▄ █░▀█ █▄█");
	        System.out.println("1. Play");
	        System.out.println("2. How to play");
	        System.out.println("0. Exit");
	        System.out.println("Select option: ");
	        
	}
	/**
	 * usarAyuda este metdo se ecnarga de recibir por parametro el numero de intentos que tiene para usar el ayuda, este se retara una vez entrado en este metodo hasta llegar a 0
	 * @param _index recibe un int
	 * @return
	 */
	public boolean usarAyuda(int _index){
		if (pistas > 0) {
			pistas --;
			System.out.println("Next color is: " + secuenciaColores[_index] + " (you have " + pistas + " hint more)");
			return true;
		}else {
			System.out.print("You have 0 hints, enter the next color:");
			return false;
		}
	}
	/**
	 * helpMenu que se encarga de ensenyar al usuario como jugar
	 * @throws IOException 
	 */
	public void helpMenu() throws IOException {
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
        System.out.println("Una vez acertada la secuencia, se le mostrará un color más en la secuencia y deberá seguir los mismos pasos.");
        System.out.println("Previamente mencionados.");
        System.out.println("\n¡Versión 2 del Simón Dice ya esta aquí!");
        System.out.println("¿Que novedades tenemos?");
        System.out.println("Esta actualización cuenta con un nuevo modo de juego y un nuevo sistema de puntuaje. Desde Emis Companys hem-");
        System.out.println("os diseñado y preparado un nuevo sistema de ayuda que al pulsar X o x, este te pondrá de forma automática el");
        System.out.println("color. A continuación, se le mostrará un ejemplo:");
        System.out.println("Sequence number 1: [Azul, Rojo, Verde]");
        System.out.println("A / a");
        System.out.println("X / x");
        System.out.println("Next color is: Rojo (you have 2 hint more)");
        System.out.println("V / v");
        System.out.println("¡Disfruta al máximo el juego! :D");
        System.out.println("\nPress ENTER to go back to the menu.");
        scn.nextLine();
        
        start();
	}
	/**
	 * start Creacion del metodo start, metodo el cual recibe un nombre que llama a la clase Jugador
	 * @throws IOException 
	 */
	  public void start() throws IOException {
		  	Scanner scn = new Scanner(System.in);
			char _menu;
			int puntuacion = 0;
		  	
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
			System.out.print("\nWhat is your name?" );
			Jugador player = new Jugador(scn.nextLine());
			
			Record record_player = new Record();
        	record_player.cargarRanking();
			record_player.addPlayer(player);
			
			System.out.print("Hello " + player.getNombre() + ", press ENTER to start playing.");
			scn.nextLine();
			
			do {
				mostrarMenu();
	        	_menu = new Scanner(System.in).next().charAt(0);

	            if (_menu == '1') {
	                for (int salto = 0; salto < 50; salto++) {
	                	System.out.println();
	                }
	                	System.out.println("¡Versión 3 del Simón Dice ya esta aquí!");
	                    System.out.println("\nSelect difficulty: ");
	                    System.out.println("1. Easy mode");
	        	        System.out.println("2. Hard mode");
	        	        System.out.println("3. 10 BEST PLAYERS");
	        	        System.out.println("4. PLAYER OR PLAYERS WITH BEST POINTS");
	        	        System.out.println("5. Back to the menu");
	        	        char playMode = new Scanner(System.in).next().charAt(0);
	        	        for (int salto = 0; salto < 50; salto++) {
	        	            System.out.println();
	        	        }
	        	        
	        	        if (playMode == '1') {
	        	        	player.setScore(play(intToModo(1)));
	        				player.getScore();
	        				record_player.ordenarRanking();
	        				record_player.escribirRanking();
	        	        }else if (playMode == '2') {
	        	        	player.setScore(play(intToModo(2)) * 2);
	        				player.getScore();
	        				record_player.ordenarRanking();
	        				record_player.escribirRanking();
	        	        }else if (playMode == '3'){
	        	        	record_player.showRancking();
	        	        	player.getScore();
	        	        	System.out.print("Press ENTER to continue.");
	        				scn.nextLine();
	        				mostrarMenu();
	        	        	
	        	        }else if (playMode == '4'){
	        	        	record_player.showBestPlayer();
	        	        	player.getScore();
	        	        	System.out.print("Press ENTER to continue.");
	        				scn.nextLine();
	        				mostrarMenu();
	        	        	
	        	        }else {
	        	            System.out.println("Entrada no válida. Introduce un número VALIDO del 1 - 3.");
	        	        }
		            } else if (_menu == '2') {
		                for (int salto = 0; salto < 50; salto++) {
		                    System.out.println();
		                }
		                helpMenu();
		            } else if (_menu == '0') {
		                for (int salto = 0; salto < 50; salto++) {
		                    System.out.println();
		                }
		                System.out.println("Good bye :(");
		                break;
		            }else {
		            System.out.println("Entrada no válida. Introduce un número VALIDO del 1 - 3.");
		        }
			} while (_menu != 0);
		}
	  		/**
	  		 * play, metodo que se encarga de llamar al método generarSecuencia y al metodo mostrarSecuencia que se encarga de recibir por consola los colores introducidos por el usuario
	  		 * @param _modo
	  		 */
			public int play(tModo _modo) {
				int puntuacion = 0;
				
				for (int salto = 0; salto < 50; salto++) {
                    System.out.println();
                }
			  	Scanner scn = new Scanner(System.in);
			  	
    			int i = 1;
				int index = 0;
				
				if (_modo == tModo.Dificil) {
    	        	generarSecuencia(MAX_COLORES_DIFICIL);
				}else
    	        	generarSecuencia(MAX_COLORES_FACIL);
					
				do {
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
    					
    					if (color_char == 'x' || color_char == 'X') {
    						if (usarAyuda(h) == true) {
	    						color_select = secuenciaColores[h];
	    						//EN VERDAD ES 8
	    						puntuacion -= 8;
	    						if(puntuacion < 8) {
	    							//PARA QUE SEA UN 0
    								puntuacion = -2;
    							}
    						}else{
    	    					color_char = new Scanner(System.in).next().charAt(0); 					
    	    					color_select = charToColor(color_char);
    						}
    					}
    					
    					if (comprobarColor(h, color_select) == true) {
    						if (h >= nivel - 1 ) {
    							i++;
    							puntuacion += 5;
    						}
    					}else{
    						if (_modo == tModo.Dificil) {
    							System.out.println("You have " + (puntuacion * 2) + " points");
        						System.out.println("You failed :(, try again next time");
        						System.out.println("Press ENTER to go to the menu.");
        						scn.nextLine();
        						return puntuacion;
    						}
    						
    						System.out.println("You have " + puntuacion + " points");
    						System.out.println("You failed :(, try again next time");
    						System.out.println("Press ENTER to go to the menu.");
    						scn.nextLine();
    						return puntuacion;
    					}
    					
    					h++;
    					puntuacion += 2;
    				}
    			}while(i <  secuenciaColores.length - 1 && comprobarColor(i, secuenciaColores[i])); // && fallo == true AND COMBROBAR COLOOR RETURN TRUE
    			
    			if (_modo == tModo.Dificil) {
    				System.out.println("Your score: " + puntuacion * 2);
        			System.out.println("Congratulations :D. You won the game");
        			System.out.println("Press ENTER to go to the menu.");
        			scn.nextLine();
				} else if (_modo == tModo.Facil) {
					System.out.println("Your score: " + puntuacion);
	    			System.out.println("Congratulations :D. You won the game");
	    			System.out.println("Press ENTER to go to the menu.");
	    			scn.nextLine();
				}
    			
    			return puntuacion;
	  }
}