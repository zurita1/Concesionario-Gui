package concecionarioDeCoches;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coche implements Serializable {

	private String matricula;
	private Modelo modelo;
	private Color color;
	private static Pattern patronMatricula = Pattern.compile("^[0-9]{4}[\\s-]?[[B-Z]&&[^EIOUQÑ]]{3}$");
	
	Coche(String matricula, Color color, Modelo modelo)
			throws colorNullException, modeloNullException, MatriculaNoValidaException {
		setModelo(modelo);
		setColor(color);
		setMatricula(matricula);
	}

	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	private void setColor(Color color) throws colorNullException {
		if (color == null)
			throw new colorNullException("El color es nulo");

		this.color = color;

	}

	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		Matcher matcher = patronMatricula.matcher(matricula);
		
		if (!matcher.matches())
			throw new MatriculaNoValidaException(
					"El formato de la matrícula no es válido (1234ZZZ,1234-ZZZ, 1234 ZZZ)");
		this.matricula = estandarizarMatricula(matricula);

	}
	

	private String estandarizarMatricula(String matricula) {
		
		return matricula.replaceAll("[- ]", "").toUpperCase();
	}

	private void setModelo(Modelo modelo) throws modeloNullException {
		if (modelo == null)
			throw new modeloNullException("El modelo es nulo");

		this.modelo = modelo;

	}
	
	public String getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public Color getColor() {
		return color;
	}

	@Override public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color +",Modelo= " + modelo+  ", marca=" + modelo.getMarca() + "]";
	}
}
