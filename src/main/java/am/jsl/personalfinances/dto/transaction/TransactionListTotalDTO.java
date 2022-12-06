package am.jsl.personalfinances.dto.transaction;

import am.jsl.personalfinances.domain.transaction.TransactionType;

import java.io.Serializable;

/**
 * TransactionListTotalDTO służy do wyświetlania sum transakcji pogrupowanych według typu transakcji i konta.
 */
public class TransactionListTotalDTO implements Serializable {

    /**
     * Typ transakcji
     */
    private byte transactionType;

    /**
     * Całkowita kwota
     */
    private double total;

    /**
     * Rodzimy symbol waluty
     */
    private String symbol;

    /**
     * Zwraca klasę css dla typu transakcji.
     *
     * @return Klasa css
     */
    public String getTransactionTypeClass() {
        return "trType" + transactionType;
    }

    /**
     * Zwraca wartość true, jeśli typ transakcji to koszt.
     *
     * @return true, jeśli typem transakcji jest koszt.
     */
    public boolean isExpense() {
        return transactionType == TransactionType.EXPENSE.getValue();
    }

    /**
     * Getter dla właściwości 'transactionType'.
     *
     * @return Wartość dla właściwości 'transactionType'.
     */
    public byte getTransactionType() {
        return transactionType;
    }

    /**
     * Setter dla właściwości 'transactionType'.
     *
     * @param transactionType Wartość do ustawienia dla właściwości'transactionType'.
     */
    public void setTransactionType(byte transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter dla właściwości 'total'.
     *
     * @return Wartość dla właściwości 'total'.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter dla właściwości 'total'.
     *
     * @param total Wartość do ustawienia dla właściwości 'total'.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter dla właściwości 'symbol'.
     *
     * @return Wartość dla właściwości 'symbol'.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setter dla właściwości 'symbol'.
     *
     * @param symbol Wartość do ustawienia dla właściwości'symbol'.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
