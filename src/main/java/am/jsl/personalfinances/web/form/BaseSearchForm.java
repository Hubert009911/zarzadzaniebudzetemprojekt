package am.jsl.personalfinances.web.form;

import java.io.Serializable;

/**
 * BaseSearchForm definiuje wspólne pola do wyszukiwania transakcji, przypomnień za pośrednictwem strony internetowej. */
public class BaseSearchForm implements Serializable {
    /**
     * Identyfikator obiektu do wyszukiwania pojedynczego obiektu.
     */
    private long id;

    /**
     * Strona do pobrania.
     */
    private int page;

    /**
     * Łączna liczba elementów na stronie
     */
    private int size;

    /**
     * Kontakt
     */
    private long contact;

    /**
     * Kategoria
     */
    private long category;

    /**
     * Konto
     */
    private long account;

    /**
     * Typ obiektu
     */
    private byte type;

    /**
     * Zakres dat utworzenia
     */
    private String daterange;

    /**
     * Opis obiektu
     */
    private String description;

    /**
     * Stan obiektu
     */
    private short status;

    /**
     * Sortowanie według pola
     */
    private String sortBy;

    /**
     * Kierunek sortowania
     */
    private boolean asc;

    /**
     * Pobranie id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Ustawienie id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Pobranie page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Ustawienie page.
     *
     * @param page the page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Pobranie size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Ustawienie size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Pobranie contact.
     *
     * @return the contact
     */
    public long getContact() {
        return contact;
    }

    /**
     * Ustawienie contact.
     *
     * @param contact the contact
     */
    public void setContact(long contact) {
        this.contact = contact;
    }

    /**
     * Pobranie category.
     *
     * @return the category
     */
    public long getCategory() {
        return category;
    }

    /**
     * Ustawienie category.
     *
     * @param category the category
     */
    public void setCategory(long category) {
        this.category = category;
    }

    /**
     * Pobranie account.
     *
     * @return the account
     */
    public long getAccount() {
        return account;
    }

    /**
     * Ustawienie account.
     *
     * @param account the account
     */
    public void setAccount(long account) {
        this.account = account;
    }

    /**
     * Pobranie type.
     *
     * @return the type
     */
    public byte getType() {
        return type;
    }

    /**
     * Ustawienie type.
     *
     * @param type the type
     */
    public void setType(byte type) {
        this.type = type;
    }

    /**
     * Pobranie daterange.
     *
     * @return the daterange
     */
    public String getDaterange() {
        return daterange;
    }

    /**
     * Ustawienie daterange.
     *
     * @param daterange the daterange
     */
    public void setDaterange(String daterange) {
        this.daterange = daterange;
    }

    /**
     * Pobranie description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawienie description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Pobranie status.
     *
     * @return the status
     */
    public short getStatus() {
        return status;
    }

    /**
     * Ustawienie status.
     *
     * @param status the status
     */
    public void setStatus(short status) {
        this.status = status;
    }

    /**
     * Pobranie sort by.
     *
     * @return the sort by
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Ustawienie sort by.
     *
     * @param sortBy the sort by
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Is asc boolean.
     *
     * @return the boolean
     */
    public boolean isAsc() {
        return asc;
    }

    /**
     * Ustawienie asc.
     *
     * @param asc the asc
     */
    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
