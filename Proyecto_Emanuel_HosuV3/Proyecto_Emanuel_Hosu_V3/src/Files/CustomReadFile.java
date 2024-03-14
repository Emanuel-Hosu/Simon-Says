package Files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import SimonDiceV3.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	private ArrayList<Jugador> players2;
	private Scanner scn;
	
	//Un string
	public CustomReadFile(String _Path) throws IOException {
		super("src/Data1/best_player.txt");
		players2 =  new ArrayList<Jugador>();
		this.scn = new Scanner(this);
	}

	@Override
	public void closeReadFIle() {
		// TODO Auto-generated method stub
		try {
			this.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Se ha producido una exepción en el metodo closeReadFile de la clase CustomReadFile");
		}
	}

	// Queda pendiente de preguntar
	@Override
	public ArrayList<Jugador> leerJugadores() {
		// TODO Auto-generated method stub
		// Tiene que leer el primer Jugador
		// "src/Data1/best_players"
		// try(BufferedReader lectura = new BufferedReader(new
		// FileReader("src/Data1/best_players"));) {
		// String cadena;
		// int cont = 0;
		// String nombre;
		// Jugador player;

		// while ((cadena = lectura.readLine()) != null) {
		// nombre = cadena.split(" ")[cont];
		// player = new Jugador(nombre);

		// players2.add(player);

		// System.out.println(cadena);

		// cont ++;
		// }
		// } catch (Exception e) {
		// TODO: handle exception
		// }

		// crear y meter jugador en el vector/ArrayList

		// Devolver un Vector o yn ArrayList tipo jugador
		// return players2;

		try (FileReader lectura = new FileReader("src/Data1/best_player.txt")) {
	        String cadena;
	        while (this.scn.hasNextLine()) {
	        	//System.out.println(scn.nextLine());
	        	//guardar puntuacion y string en dos variables diferentes
	        	//Delimitador de espacios en blanco
	        	String[] parts = scn.nextLine().split(" ");

	            String name = parts[0];
	            int score = Integer.parseInt(parts[1]);
	            
	            //ESTO ESTA BIEN
	            Jugador player = new Jugador(name);
	            player.setScore(score);
	            players2.add(player);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        //STRING EXEPCION ELEGANTE
	        System.out.println("Exepcion encontrada en el metodo leerJugadores() en la clase CustomReadFile");
	    }
	    return players2;
	    //while this.scn.hasNextLine()	    
	}

}
