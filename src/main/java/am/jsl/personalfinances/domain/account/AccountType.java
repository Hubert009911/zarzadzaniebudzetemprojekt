package am.jsl.personalfinances.domain.account;

/**
 * Wyliczenie zawierające możliwe typy kont.
 */
public enum AccountType {

    CASH((byte) 1),
    CREDIT_CARD((byte) 2),
    DEBIT_CARD((byte) 3),
    CHECK((byte) 4),
    NET_BANKING((byte) 5),
    OTHER((byte) 6);

    private byte value;

    private AccountType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
