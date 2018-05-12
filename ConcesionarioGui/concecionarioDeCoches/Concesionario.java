/**
 * 
 */
package concecionarioDeCoches;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author d17gazur
 *
 */
public class Concesionario implements Serializable {

	private ArrayList<Coche> garaje = new ArrayList<Coche>();
	static Modificado modificado = new Modificado();

	public void alta(String matricula, Color color, Modelo modelo)
			throws colorNullException, modeloNullException, MatriculaNoValidaException, cocheIdenticoException {
		Coche coche = new Coche(matricula, color, modelo);
		if (garaje.contains(coche))
			throw new cocheIdenticoException("No puedo dar de alta al coche. La matrícula ya existe");

		garaje.add(coche);
		modificado.setModificado(true);

	}
	public void altaIterador(Coche coche) throws cocheIdenticoException {			
			if (garaje.contains(coche))
				throw new cocheIdenticoException("No puedo dar de alta al coche. La matrícula ya existe");

			garaje.add(coche);
			modificado.setModificado(true);

	}
	

	public boolean baja(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		// Coche coche = new Coche(matricula);
		// if (!garaje.contains(coche))
		// throw new cocheIdenticoException("El coche no esta en el garaje");
		//
		boolean borrado = garaje.remove(new Coche(matricula));
		if (borrado) {
			modificado.setModificado(true);
			return borrado;
		}
		throw new CocheNoExisteException("El coche no esta en el garage");
	}


	public Coche getCoche(String matricula) throws MatriculaNoValidaException, IndiceErroneoException {

		try {
			Coche coche = new Coche(matricula);
			return garaje.get(garaje.indexOf(coche));
		} catch (IndexOutOfBoundsException e) {
			throw new IndiceErroneoException("El coche no existe");

		}

	}

	public ArrayList<Coche> buscarCocheColor(Color color) throws NoExisteCocheColor {
		ArrayList<Coche> cochesColores = new ArrayList<Coche>();
		for (Coche coche : garaje) {
			if (coche.getColor() == color)
				cochesColores.add(coche);
		}
		if (cochesColores.isEmpty())
			throw new NoExisteCocheColor("No hay coches de ese color en el concesionario.");
		return cochesColores;
	}
	
	public Concesionario getConcesionarioColor(Color color) throws NoExisteCocheColor, cocheIdenticoException {
		Concesionario cochesColores = new Concesionario();
		for (Coche coche : garaje) {
			if (coche.getColor() == color)
				cochesColores.altaIterador(coche);
		}
		if (cochesColores.isEmpty())
			throw new NoExisteCocheColor("No hay coches de ese color en el concesionario.");
		return cochesColores;
	}

	public boolean isEmpty() {
		return garaje.isEmpty();
	}

	public int size() {
		return garaje.size();
	}

	@Override
	public String toString() {
		return "Concesionario [garaje=" + garaje + "]";
	}
	public ListIterator<Coche> listIterator() {
		return garaje.listIterator();
	}

	

	// @Override

	// public String toString() {
	// String mensaje = "";
	// for (Coche coche : garaje) {
	// mensaje += "\n" + coche.toString();
	// }
	// return mensaje;
	// }
}
