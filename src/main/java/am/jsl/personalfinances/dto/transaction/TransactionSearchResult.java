package am.jsl.personalfinances.dto.transaction;

import am.jsl.personalfinances.search.ListPaginatedResult;

import java.io.Serializable;
import java.util.List;

/**
 *  TransactionSearchResult zawiera listę transakcji i łączne kwoty
 *  pogrupowane według typu transakcji i konta.
 * @see TransactionListTotalDTO
 * @see TransactionListDTO
 */
public class TransactionSearchResult implements Serializable {
    private List<TransactionListTotalDTO> totals;
    private ListPaginatedResult<TransactionListDTO> listPaginatedResult;

    /**
     * Getter dla właściwości 'totals'.
     *
     * @return Wartość dla właściwości 'totals'.
     */
    public List<TransactionListTotalDTO> getTotals() {
        return totals;
    }

    /**
     * Setter dla właściwości 'totals'.
     *
     * @param totals Wartość do ustawienia dla właściwości 'totals'.
     */
    public void setTotals(List<TransactionListTotalDTO> totals) {
        this.totals = totals;
    }

    public ListPaginatedResult<TransactionListDTO> getListPaginatedResult() {
        return listPaginatedResult;
    }

    public void setListPaginatedResult(ListPaginatedResult<TransactionListDTO> listPaginatedResult) {
        this.listPaginatedResult = listPaginatedResult;
    }
}
