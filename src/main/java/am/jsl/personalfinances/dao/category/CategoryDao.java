package am.jsl.personalfinances.dao.category;


import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.Category;
import am.jsl.personalfinances.dto.CategoryDTO;

import java.util.List;

/**
 * Interfejs Dao do uzyskiwania dostępu obiekt domeny {@link Category}
 */
public interface CategoryDao extends BaseDao<Category> {
    /**
     * Zwraca kategorie dla podanej nazwy użytkownika.
     * @param userId identyfikator użytkownika
     * @return Kategorie
     */
    List<CategoryDTO> getCategories(long userId);

    /**
     * Zwraca kategorie nadrzędne dla danego identyfikatora użytkownika.
     * @param userId identyfikator użytkownika
     * @return Kategorie
     */
    List<CategoryDTO> lookupParentCategories(long userId);
}
