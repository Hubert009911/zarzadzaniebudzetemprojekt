package am.jsl.personalfinances.service.category;

import am.jsl.personalfinances.domain.Category;
import am.jsl.personalfinances.dto.CategoryDTO;
import am.jsl.personalfinances.service.BaseService;

import java.util.List;

/**
 * Interfejs serwisowy, który definiuje wszystkie metody pracy z {@link Category}
 */
public interface CategoryService extends BaseService<Category> {
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
