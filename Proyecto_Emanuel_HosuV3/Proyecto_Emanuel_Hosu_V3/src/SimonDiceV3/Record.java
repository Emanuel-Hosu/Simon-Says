package SimonDiceV3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Files.CustomReadFile;
import Files.CustomWriteFile;

/**
 * @author emi
 */
public class Record {
	private final int MAX_JUGADORES= 10; 
	private Jugador[] players;
	private int cont;
	
	//CONSTRUCTORA QUE INICIALIZA LOS ATRIBUTOS
	/**
	 * Record constructora que inicializa los atributos
	 */
	public Record() {
		this.players = new Jugador[MAX_JUGADORES];
		this.cont = 0;
	}
	/**
	 * addPlayer metodo que se encarga de aniadir jugador al array players
	 * complejidad lineal
	 * @param player recibe un Jugador
	 */
	public void addPlayer(Jugador player) {
		if (this.cont < MAX_JUGADORES) {
			this.players[this.cont] = player;
			
			this.cont++;
		}
		
	}
	/**
	 * getJugadorByName metodo que recibe por parametro un string y lo convierte en jugador, devolviendo un jugador
	 * @param _nombre recibe un String
	 * @return
	 */
	public String getJugadorByName(String _nombre) {
		int stoper = 0;
		if (stoper < MAX_JUGADORES) {
			stoper = this.cont;
		}else {
			stoper = MAX_JUGADORES;
		}
		//stoper
		int i = 0;
		while (this.players[i].getNombre() != _nombre && i < stoper) {
			//equals
			if (this.players[i].getNombre().equals(_nombre)) {
				return this.players[i].getNombre();
			}
			
			i++;
		}
		return null;
	}
	/**
	 * ordenarRanking metodo que se encarga de ordenar el array players
	 * Complejidad del metodo 0(n2)
	 */
	public void ordenarRanking() {
		int stoper = 0;
		if (stoper < MAX_JUGADORES) {
			stoper = this.cont;
		}else {
			stoper = MAX_JUGADORES;
		}
		
	        for (int i = 0; i < stoper - 1; i++) {
	            for (int h = 0; h < stoper - i - 1; h++) {
	                if (this.players[h + 1].getScore() > this.players[h].getScore()) {
	                    Jugador saver = this.players[h + 1];
	                    this.players[h + 1] = this.players[h];
	                    this.players[h] = saver;
	                }
	            }
	        }
	}
	/**
	 * showRancking metodo que ordena los jugadores, acto seguido imprime los jugadores existentes (hasta 10), en pantalla al ser pedido
	 */
	public void showRancking() {
		ordenarRanking();
		System.out.println("TOP 10 PLAYERS RANKING");
		System.out.println("----------------------");
		
		for (int i = 0; i < cont; i++) {
	        System.out.println((i + 1) + "." + " " + this.players[i].getNombre() + ": " + this.players[i].getScore());
	    }
	}
	/**
	 * showBestPlayer metodo que ordena los jugadores, acto seguido elige el primer jugador de la lista y lo imprime
	 */
	public void showBestPlayer() {
		ordenarRanking();
		System.out.println("TOP 1 PLAYER - HIGH SCORE");
		System.out.println("-------------------------");
		
		int max = this.players[0].getScore();
		int stoper = 0;
		if (stoper < MAX_JUGADORES) {
			stoper = cont;
		}else {
			stoper = MAX_JUGADORES;
		}
		
		int i = 0;
		
		do {
			System.out.println(1 + "." + " " + this.players[i].getNombre() + ": " + this.players[i].getScore());
			
			i++;
		}while((i < stoper && this.players[i].getScore() == max));
	}
	/**
	 * cargarRanking metodo que crea un objeto de la clase CustomReadFile para leer el ficher
	 * @throws IOException
	 */
	public void cargarRanking() throws IOException {
		//Crear objeto CustomReadfile Para leer el fichero
		CustomReadFile leerFichero = new CustomReadFile("src/Data1/best_player.txt");
		ArrayList<Jugador> miVector = leerFichero.leerJugadores();
			//leerFichero.leerJugadores();
			
			//Meter los onbjetos del arrayList de Custom en nuestro array de record
			if (miVector == null) {
				System.out.println("No hay jugadores en el ranking");
				return;
			}
			
			for(int i = 0; i < miVector.size() - 1 && i < MAX_JUGADORES; i++) {
				Jugador currentPlayer = miVector.get(i);
				addPlayer(currentPlayer);
				//System.out.println((i + 1) + "." +currentPlayer.getNombre() + " " + currentPlayer.getScore());
			};
		
	}
	/**
	 * escribirRanking Metodo que se encarga de crear una cadena con el nombre y el score del jugador y
	 * aniade al array
	 * @throws IOException
	 */
	public void escribirRanking() throws IOException {
		//ordenarRanking();
		int stoper = 0;
		if (stoper < MAX_JUGADORES) {
			stoper = this.cont;
		}else {
			stoper = MAX_JUGADORES;
		}
		int i = 0;
		String chain = "";
		
		for (i = 0; i < stoper; i++) {
			//puntuacion nombre salto de linea
			//hay que pasar el array a string
			chain += this.players[i].getNombre() + " " +  this.players[i].getScore() + "\n";
		}
		//System.out.println(chain);
		CustomWriteFile editFile = new CustomWriteFile("src/Data1/best_player.txt");
		editFile.escribirJugadores(chain);
				
		editFile.closeFile();

	}
}
