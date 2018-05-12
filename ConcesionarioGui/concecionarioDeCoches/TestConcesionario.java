package concecionarioDeCoches;

import java.io.FileNotFoundException;
import java.io.IOException;

import utiles.Menu;
import utiles.Teclado;

public class TestConcesionario {

	static Menu menuFichero = new Menu("Gestion de Ficheros",
			new String[] { "Nuevo", "Abrir", "Guardar", "Guardar como" });

	public static void main(String[] arg) throws colorNullException, modeloNullException, cocheIdenticoException {

		Menu menuCoche = new Menu("Concesionario de coches", new String[] { "Alta", "Baja", "Mostrar un coche",
				"Mostrar un concecionario", "numero de coches", "coches de un mismo color", "GestionarGui ficheros" });

		do {
			try {
				switch (menuCoche.gestionar()) {
				case 1:
					Gestion.alta(pedirMatricula(), pedirColor(), pedirModelo());
					break;

				case 2:
					baja();
					break;

				case 3:
					System.out.println(Gestion.getCoche(pedirMatricula()));
					break;

				case 4:
					System.out.println(Gestion.mostrar());
					break;

				case 5:
					System.out.println("Numero de coches es: " + Gestion.size());
					break;

				case 6:
					System.out.println(Gestion.buscarCocheColores(pedirColor()));
					break;

				case 7:
					GestionarFicheros();
					break;

				default:
					System.out.println("Saliendo...");
					return;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// } catch (colorNullException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (modeloNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MatriculaNoValidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// } catch (cocheIdenticoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndiceErroneoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoExisteCocheColor e) {
				System.err.println("No existe ese color");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (true);

	}

	private static void baja() throws MatriculaNoValidaException {
		try {
			if (Gestion.baja(pedirMatricula()))
				System.out.println("El coche se ha eliminado correctamente");
			else
				System.out.println("El coche no se ha podido eliminar");
		} catch (CocheNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Color pedirColor() {

		Menu menuColor = new Menu("Elige un color para el coche", Color.toArray());

		switch (menuColor.gestionar()) {
		case 1:
			return Color.PLATA;
		case 2:
			return Color.ROJO;
		default:
			return Color.AZUL;

		}
	}

	private static Modelo pedirModelo() {
		Menu menuModelo = new Menu("Elige un modelo", Modelo.toArray());

		switch (menuModelo.gestionar()) {
		case 1:
			return Modelo.CORDOBA;
		case 2:
			return Modelo.TOLEDO;
		case 3:
			return Modelo.IBIZA;
		case 4:
			return Modelo.SERIE;
		case 5:
			return Modelo.SERIE2;
		default:
			return Modelo.SERIE5;

		}

	}

	private static void GestionarFicheros() throws FileNotFoundException, IOException, ClassNotFoundException {

		do {
			switch (menuFichero.gestionar()) {
			case 1:
//				Gestion.nuevo(Teclado.leerCadena("Introduce el nombre de fichero que desea guardar"),respuesta());
//				break;
//
//			case 2:
//				Gestion.abrir(Teclado.leerCadena("Introduce el nombre de fichero que desea guardar"),respuesta());
//				break;
//
//			case 3:
//				Gestion.guardar(Teclado.leerCadena("Introduce el nombre de fichero que desea guardar"));
//				break;
//
//			case 4:
//				Gestion.guardarComo(Teclado.leerCadena("Introduce el nombre de fichero que desea guardar"));
//				break;

			default:
				System.out.println("Saliendo...");
				return;
			}

		} while (true);
	}

	private static String pedirMatricula() {
		return Teclado.leerCadena("Introduzca una matricula");

	}
	private static char respuesta() {
		return Teclado.leerCaracter("Introduce 's' O 'S', si desea guardar y 'n' o 'N' en caso contrario");

	}
	

}
