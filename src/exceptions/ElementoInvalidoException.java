package exceptions;

public class ElementoInvalidoException extends Exception {

	// Se o usuario colocar um elemento que n�o esteja no range do tabuleiro,
	// o codigo vai lan�ar esta exception
	
	public ElementoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
