package SimonDiceV3;

import java.io.IOException;

/**
 * @author emi
 */
public class Main {

	public static void main(String[] args) throws IOException {
		/**
		 * @param Engine eng, objeto que se encarga de hacer la llamada a la clase Engine (motor del juego), para dar comienzo al juego
		 */
		Engine eng = new Engine();
		eng.start();
		
	}

}