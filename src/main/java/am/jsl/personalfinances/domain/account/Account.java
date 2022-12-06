package am.jsl.personalfinances.domain.account;


import am.jsl.personalfinances.domain.Descriptive;

import java.io.Serializable;
import java.util.Objects;

/**
 * Obiekt domeny konta.
 */
public class Account extends Descriptive implements Serializable {
    /**
     * Bieżące saldo tego rachunku
     */
    private double balance;

    /**
     * Typ tego konta
     * @see AccountType
     */
    private byte accountType;

    /**
     *  Kod waluty ISO 4217 tego konta
     */
    private String currency;

    /**
     * Rodzimy symbol waluty
     */
    private String symbol;

    /**
     * Stan konta. Prawda, jeśli jest aktywna
     */
    private boolean active = true;

    /**
     * Ikona tego konta
     */
    private String icon;

    /**
     * Kolor tego konta
     */
    private String color;

    /**
     * Porządek sortowania
     */
    private int sortOrder;

    /**
     * Getter dla właściwośći 'balance'.
     *
     * @return Wartość właściwośći 'balance'.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter dla właściwośći 'balance'.
     *
     * @param balance Wartość do ustawienia dla właściwości 'balance'.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getter dla właściwośći  'accountType'.
     *
     * @return Wartość dla właściwośći  'accountType'.
     */
    public byte getAccountType() {
        return accountType;
    }

    /**
     * Setter dla właściwośći  'accountType'.
     *
     * @param accountType Wartość do ustawienia dla właściwości 'accountType'.
     */
    public void setAccountType(byte accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter dla właściwośći 'currency'.
     *
     * @return Wartość dla właściwośći  'currency'.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter dla właściwośći  'currency'.
     *
     * @param currency Wartość do ustawienia dla właściwości 'currency'.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Getter dla właściwośći 'symbol'.
     *
     * @return Wartość dla właściwośći  'symbol'.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setter dla właściwośći  'symbol'.
     *
     * @param symbol Wartość do ustawienia dla właściwości 'symbol'.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Getter dla właściwośći  'active'.
     *
     * @return Wartość dla właściwośći  'active'.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter dla właściwośći  'active'.
     *
     * @param active Wartość do ustawienia dla właściwości 'active'.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Getter dla właściwośći  'icon'.
     *
     * @return Wartość dla właściwośći  'icon'.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Setter dla właściwośći  'icon'.
     *
     * @param icon Wartość do ustawienia dla właściwości 'icon'.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter dla właściwośći  'color'.
     *
     * @return Wartość dla właściwośći  'color'.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter dla właściwośći  'color'.
     *
     * @param color Wartość do ustawienia dla właściwości 'color'.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter dla właściwośći  'sortOrder'.
     *
     * @return Wartość dla właściwośći  'sortOrder'.
     */
    public int getSortOrder() {
        return sortOrder;
    }

    /**
     * Setter dla właściwośći  'sortOrder'.
     *
     * @param sortOrder Wartość do ustawienia dla właściwości 'sortOrder'.
     */
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Account) {
            final Account other = (Account) o;
            return Objects.equals(getId(), other.getId())
                    && Objects.equals(getName(), other.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
