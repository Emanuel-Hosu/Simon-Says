package Files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import SimonDiceV3.Jugador;

/**
 * @author emi
 */
public class CustomReadFile extends FileReader implements ICustomReadFile {
	private ArrayList<Jugador> players2;
	private Scanner scn;
	/**
	 * CustomReadFile constructora de CustomWriteFile
	 * @param _Path String que manda al File con un String
	 * @throws IOException
	 */
	public CustomReadFile(String _Path) throws IOException {
		super("src/Data1/best_player.txt");
		players2 =  new ArrayList<Jugador>();
		this.scn = new Scanner(this);
	}
	/**
	 * closeReadFIle metodo que se encarga de cerrar el fichero
	 */
	@Override
	public void closeReadFIle() {
		// TODO Auto-generated method stub
		try {
			this.close();
		} catch (IOException e) {
			System.out.println("Se ha producido una exepción en el metodo closeReadFile de la clase CustomReadFile");
			e.printStackTrace();
		}
	}
	/**
     * leerJugadores metodo que se ecnarga de la lectura del fichero y separar los strings en diferentes partes a traves de un split
     * me separa los nombres y el score
	 */
	@Override
	public ArrayList<Jugador> leerJugadores() {
		try (FileReader lectura = new FileReader("src/Data1/best_player.txt")) {
	        while (this.scn.hasNextLine()) {
	        	String[] parts = scn.nextLine().split(" ");

	            String name = parts[0];
	            int score = Integer.parseInt(parts[1]);
	            
	            Jugador player = new Jugador(name);
	            player.setScore(score);
	            players2.add(player);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Exepcion encontrada en el metodo leerJugadores() en la clase CustomReadFile");
	    }
	    return players2;    
	}

}
