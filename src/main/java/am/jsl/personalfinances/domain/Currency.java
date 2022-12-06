package am.jsl.personalfinances.domain;

import java.io.Serializable;

/**
 * Obiekt domeny walutowej.
 */
public class Currency implements Serializable {

    /**
     *  Trzyznakowy kod tej waluty
     */
    private String code;

    /**
     * Nazwa tej waluty
     */
    private String name;

    /**
     *  symbol tej waluty
     */
    private String symbol;

    /**
     * Getter dla właściwości 'code'.
     *
     * @return Wartość dla właściwości 'code'.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter dla właściwości 'code'.
     *
     * @param code Wartość do ustawienia dla właściwości 'code'.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter dla właściwości 'name'.
     *
     * @return Wartość dla właściwości 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter dla właściwości 'name'.
     *
     * @param name Wartość do ustawienia dla właściwości 'name'.
     */
    public void setName(String name) {
        this.name = name;
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
}
