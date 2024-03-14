package Files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile{
	/**
	 * CustomWriteFile constructora
	 * @param file ..
	 * @throws IOException ..
	 */
	public CustomWriteFile(String _Path) throws IOException {
		super("src/Data1/best_player.txt");
		// TODO Auto-generated constructor stub
	}
	/**
	 * closeFile ...
	 */
	@Override
	public void closeFile() {
		// TODO Auto-generated method stub
		try {
			this.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Se ha producido una exepción en el metodo closeFile de la clase CustomWrite");
		}
	}
	/**
	 * escribirJugadores
	 */
	@Override
	public void escribirJugadores(String Chain) {
		// TODO Auto-generated method stub
		try {
			this.write(Chain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Exepcion en el metodo escribirJugadores de clase CustomWriteFile");
		}
	}
	
}
