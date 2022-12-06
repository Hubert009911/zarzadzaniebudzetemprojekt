package am.jsl.personalfinances.dto;

/**
 * DescriptiveDTO rozszerza NamedEntity i zawiera pole opisu.
 * Używany jako klasa bazowa dla obiektów wymagających tych właściwości.
 */
public class DescriptiveDTO extends NamedDTO {
    /**
     * Opis.
     */
    private String description;

    /**
     * Getter dla właściwości 'description'.
     *
     * @return Wartość dla właściwości 'description'.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter dla właściwości 'description'.
     *
     * @param description Wartość do ustawienia dla właściwości 'description'.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
