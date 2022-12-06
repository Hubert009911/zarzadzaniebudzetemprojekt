package am.jsl.personalfinances.service;

import am.jsl.personalfinances.ex.CannotDeleteException;

import java.util.List;

/**
 * Interfejs usługi, który definiuje wszystkie metody pracy z obiektami domeny w sposób ogólny.
 * @param <T> Typ jednostki parametryzacji.
 */
public interface BaseService <T> {
    /**
     * Zwraca wszystkie wystąpienia typu dla danego użytkownika.
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return Wyniki
     */
    List<T> list(long userId);

    /**
     * Usuwa encję o podanym identyfikatorze i identyfikatorze użytkownika.
     * Będzie rzucać {@link CannotDeleteException} jeśli nie można usunąć encji.
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     * @throws CannotDeleteException Jeśli nie można usunąć encji
     */
    void delete(long id, long userId) throws CannotDeleteException;

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
     * @param object the entity
     */
    void create(T object) throws Exception;

    /**
     * Aktualizuje daną jednostkę.
     * @param object the entity
     */
    void update(T object) throws Exception;

    /**
     * Pobiera encję według jej identyfikatora i identyfikatora użytkownika.
     * @param id Identyfikator jednostki
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return the entity
     */
    T get(long id, long userId);

    /**
     * Zwraca wszystkie wystąpienia typu skojarzonego z podanym identyfikatorem użytkownika.
     * Zostanie wyświetlone zapytanie o identyfikator i nazwę wystąpienia.
     * @param userId Identyfikator użytkownika powiązany z encją
     * @return wynik
     */
    List<T> lookup(long userId);

    /**
     * Tworzy nowy plik o podanej nazwie i zawartości w katalogu publikowania użytkownika.
     * Jeśli plik o podanej nazwie istnieje, zastępuje go.
     * Opublikowany plik jest reprezentacją html obiektów określonego typu
     * i bezpośrednio ładowane przez sieć przy użyciu identyfikatora użytkownika bez trafiania do bazy danych.
     * @param userId identyfikator użytkownika
     * @param fileName Nazwa pliku
     * @param content zawartość pliku
     */
    void publish(long userId, String fileName, String content);
}
