package SimonDice;
/**
 * @author Emanuel Hosu
 */
public class Jugador {
	private String nombre;
	private int puntuacion;
	/**
	 * Jugador, una constructora que se encarga de momento, recibir el string _nombre, para luego devolverlo a la clase Enigine.
	 * @param _nombre
	 */
	public Jugador (String _nombre) {
		nombre = _nombre;
		puntuacion = 0;
	}
	/**
	 * getNombre, este es un metodo que se encarga de devolver a la clase Engine el nombre introducido por el usuario
	 * @return
	 */
	public String getNombre() {
		return "Hello " + this.nombre + ", press ENTER to start playing";
	}
		// Constructora
		// this puntacion = 0; ( para la siguiente version)
	
		//2 gets nombre y  puntuacion y 2 set puntuacion
}
