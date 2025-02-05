package am.jsl.personalfinances.domain.user;

/**
 * Wyliczenie zawierające możliwe typy tokenów weryfikacyjnych.
 */
public enum VerificationTokenType {
    NEW_ACCOUNT((byte) 1),
    PASSWORD_RESET ((byte) 2);

    private byte value;

    VerificationTokenType(byte value) {
        this.value = value;
    }

    /**
     * Getter dla właściwości 'value'.
     *
     * @return Wartość dla właściwości 'value'.
     */
    public byte getValue() {
        return value;
    }
}
