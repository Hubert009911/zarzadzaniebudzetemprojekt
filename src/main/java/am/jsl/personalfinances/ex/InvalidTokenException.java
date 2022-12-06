package am.jsl.personalfinances.ex;

/**
 * Zostanie wygenerowany, jeśli token użytkownika jest nieprawidłowy lub wygasł.
 */
public class InvalidTokenException extends RuntimeException {
	public static final String CODE = "error.invalid.token";

	public InvalidTokenException() {
		super();
	}

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTokenException(String message) {
		super(message);
	}

	public InvalidTokenException(Throwable cause) {
		super(cause);
	}

	public String getMessageCode() {
		return CODE;
	}
}
