package am.jsl.personalfinances.dto;

import java.io.Serializable;

/**
 * Obiekt DTO, który rozszerza BaseDTO i zawiera pole nazwy.
 * Używany jako klasa bazowa dla obiektów wymagających tych właściwości.
 */
public class NamedDTO  extends BaseDTO implements Serializable {
    /**
     * Nazwa
     */
    private String name;

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
     * @param name Wartość do ustawienia dla właściwości  'name'.
     */
    public void setName(String name) {
        this.name = name;
    }
}
