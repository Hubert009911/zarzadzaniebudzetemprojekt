package am.jsl.personalfinances.search;

/**
 * Podstawowa klasa kwerendy zawierająca informacje o paginacji służące do wykonywania kwerend dotyczących elementów w sposób ogólny.
 *
 * @param <T> Parametr typu
 */
public class Query<T> {
	/**
	 * Identyfikator elementu, który ma zostać znaleziony.
	 */
	protected long id;
	/**
	 * Bieżąca strona do odpytywania.
	 */
	protected int page = 1;
	/**
	 * Liczba przedmiotów do zwrotu.
	 */
	protected int pageSize = -1;
	/**
	 * Sortuj według.
	 */
	protected String sortBy;
	/**
	 * True,jeśli sortuje się według porządku rosnącego.
	 */
	protected boolean asc;

	/**
	 * Tworzy wystąpienie nowego Query.
	 */
	public Query() {
	}

	/**
	 * Tworzy wystąpienie nowego Query.
	 *
	 * @param page     strona
	 * @param pageSize rozmiar strony
	 */
	public Query(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}


	/**
	 * Pobiera id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Ustawia id.
	 *
	 * @param id the id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Pobiera page.
	 *
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Ustawia page.
	 *
	 * @param page the page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * Pobiera page size.
	 *
	 * @return the page size
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Ustawia page size.
	 *
	 * @param pageSize the page size
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Pobiera sort by.
	 *
	 * @return the sort by
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * Ustawia sort by.
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
	 * Ustawia asc.
	 *
	 * @param asc the asc
	 */
	public void setAsc(boolean asc) {
		this.asc = asc;
	}
}
