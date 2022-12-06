package am.jsl.personalfinances.web.util;

/**
 * JsonResponse jest używany w wywołaniach ajax do wysyłania odpowiedzi.
 */
public class JsonResponse {
    /**
     * Flaga wskazująca stan odpowiedzi.
     */
    private boolean error = false;
    /**
     * Obiekt wynikowy.
     */
    private Object result = null;

    /**
     * Czy błąd boolean.
     *
     * @return the boolean
     */
    public boolean isError() {
        return error;
    }

    /**
     * Ustawienie error.
     *
     * @param error the error
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Pobranie result.
     *
     * @return the result
     */
    public Object getResult() {
        return result;
    }

    /**
     * Ustawienie result.
     *
     * @param result the result
     */
    public void setResult(Object result) {
        this.result = result;
    }
}