package am.jsl.personalfinances.dto.transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Zawiera listę transakcji pogrupowanych według kategorii i konta.
 */
public class TransactionByCategoryResultDTO implements Serializable {

    /**
     * Całkowita kwota
     */
    private String totalStr;

    /**
     * Lista zgrupowanych transakcji
     */
    private List<TransactionByCategoryDTO> list;

    /**
     * Getter dla właściwości 'totalStr'.
     *
     * @return Wartość dla właściwości 'totalStr'.
     */
    public String getTotalStr() {
        return totalStr;
    }

    /**
     * Setter dla właściwości 'totalStr'.
     *
     * @param totalStr Wartość do ustawienia dla właściwości 'totalStr'.
     */
    public void setTotalStr(String totalStr) {
        this.totalStr = totalStr;
    }

    /**
     * Getter dla właściwości 'list'.
     *
     * @return Wartość dla właściwości 'list'.
     */
    public List<TransactionByCategoryDTO> getList() {
        return list;
    }

    /**
     * Setter dla właściwości 'list'.
     *
     * @param list Wartość do ustawienia dla właściwości 'list'.
     */
    public void setList(List<TransactionByCategoryDTO> list) {
        this.list = list;
    }
}
