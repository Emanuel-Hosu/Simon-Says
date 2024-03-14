package Files;
/**
 * @author emi
 */
public interface ICustomWriteFile {
	/**
	 * closeFile metodo que se encarga de cerrar el fichero
	 */
	void closeFile();
	/**
	 * escribirJugadores metodo que se encarga de escribir los jugaodres en el array
	 * @param Chain recibe un String
	 */
	void escribirJugadores(String Chain);
}
