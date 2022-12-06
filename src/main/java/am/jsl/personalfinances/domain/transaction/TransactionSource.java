package am.jsl.personalfinances.domain.transaction;

import java.io.Serializable;

/**
 * Wyliczenie zawierające możliwe źródła transakcji.
 */
public enum TransactionSource implements Serializable {

    /**
     * Źródło ręczne wskazuje transakcje utworzone przez użytkownika (przychody, koszty, transfer)
     */
    MANUAL((byte) 1),

    /**
     * Źródło pożyczek wskazuje transakcje utworzone przez zadanie przypomnienia
     */
    REMINDER((byte) 2);

    private byte value;

    TransactionSource(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

}
