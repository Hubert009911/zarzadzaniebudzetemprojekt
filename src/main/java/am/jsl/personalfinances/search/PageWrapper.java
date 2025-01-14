package am.jsl.personalfinances.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * PageWrapper używany w stronach thymeleaf do wyświetlania pojedynczej strony
 * z obsługą paginacji.
 */
public class PageWrapper<T> {
    public static final int MAX_PAGE_ITEM_DISPLAY = 5;
    private boolean firstPageEnabled;
    private boolean previousPageEnabled;
    private boolean nextPageEnabled;
    private boolean lastPageEnabled;

    private int size = 0;
    private long dataCount;
    private int currentPage;
    private int pageSize;
    private int totalPages = 0;
    private List<T> content;
    private List<PageItem> items;

    public PageWrapper(ListPaginatedResult<T> result, int currentPage, int pageSize){
        this(result.getList(), result.getTotal(), currentPage, pageSize);
    }

    public PageWrapper(List<T> content, long total, int currentPage, int pageSize){
        this.content = content;
        this.dataCount = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = (int) dataCount / pageSize;

        if ((dataCount % pageSize) > 0) {
            totalPages += 1;
        }

        if (totalPages <= 1) {
            return;
        }
        boolean firstLastPageEnabled = (totalPages >= 2);

        if (currentPage == 1) {
            firstPageEnabled = false;
            previousPageEnabled = false;
            nextPageEnabled = true;
            lastPageEnabled = firstLastPageEnabled;
        } else if (currentPage == totalPages) {
            firstPageEnabled = firstLastPageEnabled;
            previousPageEnabled = true;
            nextPageEnabled = false;
            lastPageEnabled = false;
        } else {
            firstPageEnabled = firstLastPageEnabled && (currentPage >= 2);
            previousPageEnabled = true;
            nextPageEnabled = true;
            lastPageEnabled = firstLastPageEnabled
                    && (currentPage < (totalPages - 1));
        }

        int start, size;
        if (totalPages <= pageSize) {
            start = 1;
            size = totalPages;
        } else {
            if (currentPage <= MAX_PAGE_ITEM_DISPLAY - MAX_PAGE_ITEM_DISPLAY/2) {
                start = 1;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else if (currentPage >= totalPages - MAX_PAGE_ITEM_DISPLAY/2) {
                start = totalPages - MAX_PAGE_ITEM_DISPLAY + 1;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else {
                start = currentPage - MAX_PAGE_ITEM_DISPLAY/2;
                size = MAX_PAGE_ITEM_DISPLAY;
            }
        }

        items = new ArrayList<PageItem>();

        IntStream.range(0, size).forEach(i -> items.add(new PageItem(start + i, (start + i) == currentPage)));
    }


    public boolean isPreviousPageEnabled() {
        return previousPageEnabled;
    }

    public void setPreviousPageEnabled(boolean previousPageEnabled) {
        this.previousPageEnabled = previousPageEnabled;
    }

    public boolean isFirstPageEnabled() {
        return firstPageEnabled;
    }

    public void setFirstPageEnabled(boolean firstPageEnabled) {
        this.firstPageEnabled = firstPageEnabled;
    }

    public boolean isNextPageEnabled() {
        return nextPageEnabled;
    }

    public void setNextPageEnabled(boolean nextPageEnabled) {
        this.nextPageEnabled = nextPageEnabled;
    }

    public boolean isLastPageEnabled() {
        return lastPageEnabled;
    }

    public void setLastPageEnabled(boolean lastPageEnabled) {
        this.lastPageEnabled = lastPageEnabled;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public List<PageItem> getItems() {
        return items;
    }

    public void setItems(List<PageItem> items) {
        this.items = items;
    }

    /**
     * Getter dla właściwości 'currentPage'.
     *
     * @return Wartość dla właściwości 'currentPage'.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Setter dla właściwości 'currentPage'.
     *
     * @param currentPage Wartość do ustawienia dla właściwości 'currentPage'.
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Getter dla właściwości 'dataCount'.
     *
     * @return Wartość dla właściwości 'dataCount'.
     */
    public long getDataCount() {
        return dataCount;
    }

    /**
     * Setter dla właściwości 'dataCount'.
     *
     * @param dataCount Wartość do ustawienia dla właściwości 'dataCount'.
     */
    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * Getter dla właściwości 'pageSize'.
     *
     * @return Wartość dla właściwości 'pageSize'.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter dla właściwości 'pageSize'.
     *
     * @param pageSize Wartość do ustawienia dla właściwości 'pageSize'.
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public class PageItem {
        private int number;
        private boolean current;

        public PageItem(int number, boolean current) {
            this.number = number;
            this.current = current;
        }

        public int getNumber() {
            return this.number;
        }

        public boolean isCurrent() {
            return this.current;
        }
    }
}
