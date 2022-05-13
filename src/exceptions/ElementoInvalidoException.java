package exceptions;

public class ElementoInvalidoException extends Exception {

	// Se o usuario colocar um elemento que não esteja no range do tabuleiro,
	// o codigo vai lançar esta exception
	
	public ElementoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
