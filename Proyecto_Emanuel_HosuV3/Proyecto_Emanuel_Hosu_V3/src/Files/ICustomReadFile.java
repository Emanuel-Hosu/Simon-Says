package Files;
import java.util.ArrayList;
import SimonDiceV3.Jugador;
/**
 * @author emi
 */
public interface ICustomReadFile{
	/**
	 * closeReadFIle metodo que se encarga de cerrar el fichero
	 */
	void closeReadFIle();
	/**
	 * leerJugadores metodo que se encarga de leer el interior del fichero
	 * @return
	 */
	ArrayList<Jugador> leerJugadores();
	
}
