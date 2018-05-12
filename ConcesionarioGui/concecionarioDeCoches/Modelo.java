package concecionarioDeCoches;

public enum Modelo {
	CORDOBA(Marca.SEAT), 
	TOLEDO(Marca.SEAT), 
	IBIZA(Marca.SEAT), 
	SERIE(Marca.BMW), 
	SERIE2(Marca.BMW), 
	SERIE3(Marca.BMW), 
	SERIE5(Marca.BMW);

	private Marca marca;
	
	private Modelo(Marca marca) {	
		setMarca(marca);
	}
	
	public  Marca getMarca() {
		return marca;
	}

	private void setMarca(Marca marca) {
		this.marca = marca;
	}

	public static String[] toArray() {
		String[] arrayModelo = new String[Modelo.values().length];
		int i = 0;
		for (Modelo modelo : Modelo.values())
			arrayModelo[i++] = modelo.toString();
		return arrayModelo;
	}

}
