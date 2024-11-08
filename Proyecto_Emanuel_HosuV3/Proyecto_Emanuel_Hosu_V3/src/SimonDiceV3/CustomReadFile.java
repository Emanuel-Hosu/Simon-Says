package SimonDiceV3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomReadFile extends FileWriter implements ICustomReadFile {
	ArrayList<Jugador> players2 = new ArrayList<Jugador>();

	public CustomReadFile(File file) throws IOException {
		super(file);
	}

	@Override
	public void closeReadFIle() {
		// TODO Auto-generated method stub
		this.closeReadFIle();
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

		try (BufferedReader lectura = new BufferedReader(new FileReader("src/Data1/best_players.txt"))) {
	        String cadena;
	        while ((cadena = lectura.readLine()) != null) {
	        	//Delimitador de espacios en blanco
	        	String[] parts = cadena.split("\\s+");

	        	
	            String name = parts[0];
	            int score = Integer.parseInt(parts[1]);

	            Jugador player = new Jugador(name);
	            players2.add(player);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return players2;
	}

}
