package concecionarioDeCoches;

public enum Color {
	PLATA, ROJO, AZUL;

	public static String[] toArray() {
		String[] arrayColor = new String[Color.values().length];
		int i = 0;
		for (Color color : Color.values())
			arrayColor[i++] = color.toString();
		return arrayColor;
		
	}
}
