package SimonDice;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Engine {
	/**
	 * @param clase tColores con los colores
	 */
	public enum tColores{
		Rojo, Azul, Verde, Dorado
	}
	/**
	 * @param secuencia maxima de colores 
	 */
	private static final int MAX_COLORES_SEQ = 12;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	
	/**
	 * @param _color
	 * @return
	 */
		public tColores charToColor (char _color) {
		switch (Character.toUpperCase(_color)) {
	        case 'R':
	            return tColores.Rojo;
	        case 'A':
	            return tColores.Azul;
	        case 'V':
	            return tColores.Verde;
	        case 'D':
	            return tColores.Dorado;
	        default:
	            throw new IllegalArgumentException("Not valid color: " + _color);
		}
	}
	/**
	 * @param _numero
	 * @return
	 */
		public tColores intToColor (int _numero) {
		switch (Character.toUpperCase(_numero)) {
	        case 0:
	            return tColores.Rojo;
	        case 1:
	            return tColores.Azul;
	        case 2:
	            return tColores.Verde;
	        case 3:
	            return tColores.Dorado;
	        default:
	            throw new IllegalArgumentException("Not valid color: " + _numero);
		}
	}
		/**
		 * 
		 * @param _numColores
		 */
		 public void generarSecuencia(int _numColores) {
			//Random randomColor = new Random();
			//int [] secuenciaColores = new int [_numColores];

		    //for (int i = 0; i < _numColores; i++) {
		    //	 int colorAleatorio = randomColor.nextInt(_numColores) + 1;
		    //	 secuenciaColores[i] = colorAleatorio;   
		    //	 System.out.print(colorAleatorio + " ");
		    // }
			/*
			Scanner scn = new Scanner(System.in);
			Random randomColor = new Random();
			 int contadorseq = 1;
			 int secuencia = 3;
			 int numColores = 3;
			    	    
			    do {
			        System.out.print("\nSequence number " + contadorseq + ": ");
			        for (int i = 0; i <  secuencia; i++) { //ANTES TENIA PUESTO EL NUMCOLORES
			        	int colorAleatorio = randomColor.nextInt(numColores + 1);
			        	this.secuenciaColores[i]=intToColor(colorAleatorio);
		                //tColores colorEnum = intToColor(colorAleatorio); //ESTO SIRVE PARA PONERLE NOMBRE A LOS NUMEROS
		                System.out.print(secuenciaColores[i] + " ");
			        }
			        System.out.println("\nMemorize the sequence and press ENTER to continue...");
			        scn.nextLine();
			        String _color = scn.nextLine();
			        
			        secuencia++;
			        contadorseq++;
			       } while (secuencia < secuenciaColores.length); // AQUI HABIRA QUE PONER UN AND SOBRE SI LA SECUENCIA QUE INTRODUCE EL USUARIO ES VALIDA. Puedes ajustar el número de secuencias según tus necesidades
		  */
			 Random randomColor = new Random();

			 int numsec = 2;
				 for (int i = 0; i < secuenciaColores.length; i++) {
					    int colorAleatorio = randomColor.nextInt(_numColores + 1);
					    secuenciaColores[i] = intToColor(colorAleatorio);

					    if (i == numsec) {
					        break;
					    }
				 }
				 
				 // SIRVE PARA IMPRIMIR LA SECUENCIA
				 /* System.out.print("[ ");
				 for (int i = 0; i < secuenciaColores.length; i++) {
				     System.out.print(secuenciaColores[i]);
				     if (i < secuenciaColores.length - 1) {
				         System.out.print(", ");
				     }
				 }
				 System.out.println(" ]");*/
		 }
		 
		 public boolean comprobarColor(int _index, tColores _color) {
			 if (secuenciaColores[_index] == _color)
				 return true;
			 else
				 return false;
		 }
		 
		 public void mostrarSecuencia (int _numero) {
			 	generarSecuencia(3);
				System.out.print("\nSequence number " + _numero + ": " + Arrays.toString(secuenciaColores));
				
				//IF comprobarColor ns k true _numero++ y lo mismo va en el start() y hacer el for del pdf
		 }
	/**
	 * @param Creacion del metodo start
	 */
	  public void start() {
		  	Scanner scn = new Scanner(System.in);
		  	
			/**
			 * @param Menu de Simon Dice
			 */
	        System.out.println("Welcome to...");
			System.out.println("			██╗");
			System.out.println("			╚█║");
			System.out.println("			░╚╝");
			System.out.println("░██████╗██╗███╗░░░███╗░█████╗░███╗░░██╗  ██████╗░██╗░█████╗░███████╗");
			System.out.println("██╔════╝██║████╗░████║██╔══██╗████╗░██║  ██╔══██╗██║██╔══██╗██╔════╝");
			System.out.println("╚█████╗░██║██╔████╔██║██║░░██║██╔██╗██║  ██║░░██║██║██║░░╚═╝█████╗░░");
			System.out.println("░╚═══██╗██║██║╚██╔╝██║██║░░██║██║╚████║  ██║░░██║██║██║░░██╗██╔══╝░░");
			System.out.println("██████╔╝██║██║░╚═╝░██║╚█████╔╝██║░╚███║  ██████╔╝██║╚█████╔╝███████╗");
			System.out.println("╚═════╝░╚═╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝  ╚═════╝░╚═╝░╚════╝░╚══════╝");
			
			System.out.print("\nWhat is your name?" ); // Aqui se instancia el objeto jugador
			Jugador player = new Jugador(scn.nextLine());
			System.out.print(player.getNombre());
			scn.nextLine(); // Wait for ENTER
			int i = 1;
			
			do {
				mostrarSecuencia(i);
				System.out.print("\nMemorize the sequence and press ENTER to continue...");
				scn.nextLine();
				char color = new Scanner(System.in).next().charAt(0);
				charToColor(color);
				
				
			}while(i <  secuenciaColores.length); //AND COMBROBAR COLOOR RETURN TRUE
		    
		    	    
		    /*do {
		        /**
		        * @param Imprime los nombres aleatorios
		        
		        System.out.print("\nSequence number " + contadorseq + ": ");
		        for (int i = 0; i < secuencia; i++) {
		             tColores colorAleatorio = tColores.values()[random.nextInt(tColores.values().length)];
		             System.out.print(colorAleatorio + " ");
		            }
		        System.out.println("\nMemorize the sequence and press ENTER to continue...");
		        scn.nextLine();
		        String _color = scn.nextLine();
		        
		        secuencia++;
		        contadorseq++;
		       } while (secuencia < secuenciaColores.length); // AQUI HABIRA QUE PONER UN AND SOBRE SI LA SECUENCIA QUE INTRODUCE EL USUARIO ES VALIDA. Puedes ajustar el número de secuencias según tus necesidades*/
	  }
}
