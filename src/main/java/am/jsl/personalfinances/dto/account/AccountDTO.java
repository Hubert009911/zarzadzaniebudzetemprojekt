package am.jsl.personalfinances.dto.account;

import am.jsl.personalfinances.domain.account.Account;
import am.jsl.personalfinances.dto.DescriptiveDTO;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;

/**
 * Służy do przesyłania danych konta między stronami internetowymi i kontrolerami.
 */
public class AccountDTO extends DescriptiveDTO implements Serializable {

    /**
     *  Bieżące saldo tego konta.
     */
    @NumberFormat(pattern = "#,##0.00")
    private double balance;

    /**
     * Typ tego konta.
     */
    private byte accountType;

    /**
     *  Kod waluty ISO 4217 tego konta.
     */
    private String currency;

    /**
     * Rodzimy symbol waluty
     */
    private String symbol;

    /**
     * Stan konta. True, jeśli jest aktywny.
     */
    private boolean active = true;

    /**
     * Ikona tego konta.
     */
    private String icon;

    /**
     * Kolor tego konta.
     */
    private String color;

    /**
     * Kolejność sortowania
     */
    private int sortOrder;

    /**
     * Getter dla właściwości'balance'.
     *
     * @return Wartość dla właściwości 'balance'.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter dla właściwości 'balance'.
     *
     * @param balance Wartość do ustawienia dla właściwości 'balance'.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getter dla właściwości 'accountType'.
     *
     * @return Wartość dla właściwości 'accountType'.
     */
    public byte getAccountType() {
        return accountType;
    }

    /**
     * Setter dla właściwości 'accountType'.
     *
     * @param accountType Wartość do ustawienia dla właściwości 'accountType'.
     */
    public void setAccountType(byte accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter dla właściwości 'currency'.
     *
     * @return Wartość dla właściwości 'currency'.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter dla właściwości 'currency'.
     *
     * @param currency Wartość do ustawienia dla właściwości 'currency'.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Getter dla właściwości 'active'.
     *
     * @return Wartość dla właściwości 'active'.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter dla właściwości 'active'.
     *
     * @param active Wartość do ustawienia dla właściwości 'active'.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Getter dla właściwości 'icon'.
     *
     * @return Wartość dla właściwości 'icon'.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Setter dla właściwości 'icon'.
     *
     * @param icon Wartość do ustawienia dla właściwości 'icon'.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter dla właściwości 'color'.
     *
     * @return Wartość dla właściwości 'color'.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter dla właściwości 'color'.
     *
     * @param color Wartość do ustawienia dla właściwości 'color'.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter dla właściwości 'sortOrder'.
     *
     * @return Wartość dla właściwości 'sortOrder'.
     */
    public int getSortOrder() {
        return sortOrder;
    }

    /**
     * Setter dla właściwości 'sortOrder'.
     *
     * @param sortOrder Wartość do ustawienia dla właściwości 'sortOrder'.
     */
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
     * @param symbol Wartość do ustawienia dla właściwości 'symbol'.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setId(getId());
        account.setName(getName());
        account.setDescription(getDescription());
        account.setBalance(getBalance());
        account.setAccountType(getAccountType());
        account.setCurrency(getCurrency());
        account.setSymbol(getSymbol());
        account.setActive(isActive());
        account.setSortOrder(getSortOrder());
        account.setIcon(getIcon());
        account.setColor(getColor());
        return account;
    }

    public static AccountDTO from(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setDescription(account.getDescription());
        dto.setBalance(account.getBalance());
        dto.setAccountType(account.getAccountType());
        dto.setCurrency(account.getCurrency());
        dto.setSymbol(account.getSymbol());
        dto.setActive(account.isActive());
        dto.setSortOrder(account.getSortOrder());
        dto.setIcon(account.getIcon());
        dto.setColor(account.getColor());
        return dto;
    }
}
