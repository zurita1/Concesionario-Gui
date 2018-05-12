package concecionarioDeCoches;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Fichero {

	
	static File file;

	public Fichero(File file) {
		setFile(file);
	}

	public static  void setFile(File file) {
		file = file;

	}
	
	public static Object getFile() {
		return file;
	}

	public  void guardar(Concesionario concesionario, File file)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream fichero = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			fichero.writeObject(concesionario);
			setFile(file);
		}
	}

	public  Concesionario abrir(File file)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream fichero = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			Concesionario concesionario = (Concesionario) fichero.readObject();
			setFile(file);
			return concesionario;
		}
	}

	public  void guardarComo(Concesionario concesionario, File file)
			throws FileNotFoundException, IOException {
		setFile(file);
		guardar(concesionario, file);
	}

	

}