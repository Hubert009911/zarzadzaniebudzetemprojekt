package am.jsl.personalfinances.ex;

/**
 * Zostanie wygenerowany, jeśli adres e-mail użytkownika już istnieje podczas rejestracji użytkownika.
 */
public class DuplicateEmailException extends Exception {

    public DuplicateEmailException() {
    }

    public DuplicateEmailException(String arg0) {
        super(arg0);
    }

    public DuplicateEmailException(Throwable arg0) {
        super(arg0);
    }

    public DuplicateEmailException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DuplicateEmailException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
