package am.jsl.personalfinances.dao;

import java.util.List;

/**
 * Podstawowy interfejs DAO do interakcji z obiektami encji domeny w sposób ogólny.
 * @param <T> Typ jednostki parametryzacji.
 */
public interface BaseDao<T> {
    /**
     * Zwraca wszystkie wystąpienia typu dla danego użytkownika.
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return Wyniki
     */
    List<T> list(long userId);

    /**
     * Zwraca informację, czy można usunąć jednostkę o podanym identyfikatorze i identyfikatorze użytkownika.
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return true, jeśli encja o podanym identyfikatorze i identyfikatorze użytkownika może zostać usunięta
     */
    boolean canDelete(long id, long userId);

    /**
     * Usuwa encję o podanym identyfikatorze i identyfikatorze użytkownika.
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     */
    void delete(long id, long userId);

    /**
     * Zwraca informację, czy istnieje encja o podanym identyfikatorze i identyfikatorze użytkownika.
     * @param name Nazwa encji
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return true, jeśli istnieje encja o podanym identyfikatorze i identyfikatorze użytkownika
     */
    boolean exists(String name, long id, long userId);

    /**
     * Tworzy daną jednostkę.
     * @param object jednostka
     */
    void create(T object);

    /**
     * Aktualizuje daną jednostkę.
     * @param object jednostka
     */
    void update(T object);

    /**
     * Pobiera encję według jej identyfikatora i identyfikatora użytkownika.
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return jednostka
     */
    T get(long id, long userId);

    /**
     * Zwraca wszystkie wystąpienia typu skojarzonego z podanym identyfikatorem użytkownika.
     * Zostanie wyświetlone zapytanie o identyfikator i nazwę wystąpienia.
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return Wynik
     */
    List<T> lookup(long userId);
}
