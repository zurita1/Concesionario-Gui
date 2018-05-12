package concecionarioDeCoches;

public class Modificado {

	private static boolean modificado=false;
	
	void modificado(boolean modificado){
		setModificado(modificado);
	}

	public  void setModificado(boolean modificado) {
		this.modificado=modificado;
		
	}

	public static boolean isModificado() {
		return modificado;

	}
}
