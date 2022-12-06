package am.jsl.personalfinances.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Zawija wyniki paginacji list.
 */
public class ListPaginatedResult<T> implements Serializable {

	/**
	 * Łączna liczba elementów.
	 */
	private long total = 0;

	/**
	 * Wynik podzielony na strony.
	 */
	private List<T> list = new ArrayList<T>();

	/**
	 * Getter dla właściwości 'total'.
	 *
	 * @return Wartość dla właściwości 'total'.
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * Setter dla właściwości 'total'.
	 *
	 * @param total Wartość do ustawienia dla właściwości 'total'.
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * Getter dla właściwości 'list'.
	 *
	 * @return Wartość dla właściwości 'list'.
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * Setter dla właściwości 'list'.
	 *
	 * @param list Wartość do ustawienia dla właściwości 'list'.
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
}
