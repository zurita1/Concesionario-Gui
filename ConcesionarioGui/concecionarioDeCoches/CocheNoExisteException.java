package concecionarioDeCoches;

public class CocheNoExisteException extends Exception {
	CocheNoExisteException(String string) {
		super(string);
	}
}
