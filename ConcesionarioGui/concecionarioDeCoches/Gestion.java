package concecionarioDeCoches;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import utiles.Menu;
import utiles.Teclado;

public class Gestion {
	public static Fichero fichero;
	static Modificado modificado = new Modificado();
	static File file;
	public static  Concesionario concesionario = new Concesionario();
	static {
		try {
			concesionario.alta("1111VVV", Color.ROJO, Modelo.CORDOBA);
			concesionario.alta("2222VVV", Color.PLATA, Modelo.TOLEDO);
			concesionario.alta("3333VVV", Color.AZUL, Modelo.SERIE);
			concesionario.alta("4444VVV", Color.ROJO, Modelo.SERIE2);
		} catch (colorNullException | modeloNullException | MatriculaNoValidaException | cocheIdenticoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void guardarComo() throws FileNotFoundException, IOException {

		fichero.guardarComo(concesionario, file);

	}

	public static void guardar(File file) throws FileNotFoundException, IOException {
		if (Fichero.getFile()== null) {
			guardarComo();
		} else
			fichero.guardar(concesionario, file);
	}

	public static void abrir(File file )
			throws FileNotFoundException, IOException, ClassNotFoundException {

		if (Modificado.isModificado()) {
					fichero.guardar(concesionario, file);
			}
		
		fichero.abrir(file);
	}

	public static boolean respuesta(char respuesta) {

		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}

	public static void nuevo(Concesionario concesionario,File file) throws FileNotFoundException, IOException {
		if (Modificado.isModificado()) {
			
				fichero.guardar(concesionario, file);
			}
		
		 concesionario = new Concesionario();
	}

	public static ArrayList<Coche> buscarCocheColores(Color color) throws NoExisteCocheColor, cocheIdenticoException {
		return concesionario.buscarCocheColor(color);
	}

	public static Coche getCoche(String matricula) throws MatriculaNoValidaException, IndiceErroneoException {
		return concesionario.getCoche(matricula);
	}

	public static boolean baja(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		return concesionario.baja(matricula);
	}

	public static void alta(String matricula, Color color, Modelo modelo)
			throws colorNullException, modeloNullException, MatriculaNoValidaException, cocheIdenticoException {
		concesionario.alta(matricula, color, modelo);
	}

	public static String mostrar() {
		return concesionario.toString();
	}

	public static int size() {
		return concesionario.size();
	}

}
