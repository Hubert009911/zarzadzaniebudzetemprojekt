package am.jsl.personalfinances.dao;

import am.jsl.personalfinances.domain.NamedEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementacja interfejsu BaseDao z obsługą JDBC Dao firmy Springframework
 * <p>Wymaga {@link javax.sql.DataSource} do ustawienia.
 *
 * @param <T> Parametr typu
 */
public class BaseDaoImpl<T> extends AbstractDaoImpl implements BaseDao<T> {

    /**
     * Program mapowania wierszy dla ogólnego typu {@link NamedEntity}
     */
    protected NamedEntityMapper namedMapper = new NamedEntityMapper();

    /**
     * Tworzy nowy BaseDaoImpl dla danego {@link DataSource}.
     *
     * @param dataSource źródło danych JDBC, aby uzyskać dostęp
     */
    public BaseDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<T> list(long userId) {
        return null;
    }

    /**
     * List list.
     *
     * @param userId    identyfikator użytkownika
     * @param sql       sql
     * @param rowMapper Mapowanie wierszy
     * @return lista
     */
    protected List<T> list(long userId, String sql, RowMapper<T> rowMapper) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.user_id, userId);

        return parameterJdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public boolean canDelete(long id, long userId) {
        return true;
    }

    @Override
    public void delete(long id, long userId) {

    }

    @Override
    public boolean exists(String name, long id, long userId) {
        return false;
    }

    @Override
    public void create(T object) {

    }

    @Override
    public void update(T object) {

    }

    @Override
    public T get(long id, long userId) {
        return null;
    }

    @Override
    public List<T> lookup(long userId) {
        return null;
    }

    /**
     * Pobiera jednostkę według jej identyfikatora, identyfikatora użytkownika i sql.
     * @param id     Identyfikator jednostki
     * @param userId Identyfikator użytkownika skojarzony z jednostką
     * @param sql    Kod SQL do wykonywania zapytań do jednostki
     * @param mapper Mapowanie dla jednostki mapowania z {@link java.sql.ResultSet}
     * @return the entity
     */
    protected T get(long id, long userId, String sql, RowMapper<T> mapper) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.id, id);
        params.put(DBUtils.user_id, userId);

        try {
            return parameterJdbcTemplate.queryForObject(sql, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Zwraca wszystkie wystąpienia NamedEntity dla danego użytkownika.
     * @param userId Identyfikator użytkownika skojarzony z jednostką
     * @param sql    SQL dla jednostek zapytań
     * @return lista
     */
    protected List<NamedEntity> lookup(long userId, String sql) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.user_id, userId);

        return parameterJdbcTemplate.query(sql, params, namedMapper);
    }

    /**
     * Zwraca wszystkie wystąpienia typu dla danego użytkownika.
     * @param userId    Identyfikator użytkownika skojarzony z jednostką
     * @param sql       SQL dla jednostek zapytań
     * @param rowMapper Mapowanie dla mapowania jednostek z {@link java.sql.ResultSet}
     * @return lista
     */
    protected List<T> lookup(long userId, String sql, RowMapper<T> rowMapper) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.user_id, userId);

        return parameterJdbcTemplate.query(sql, params, rowMapper);
    }

    /**
     * Zwraca ciąg z danej encji.
     * @param id     Identyfikator jednostki
     * @param userId Identyfikator użytkownika skojarzony z jednostką
     * @param sql    Kod SQL dla ciągu zapytań
     * @return the string
     */
    protected String getString(long id, long userId, String sql) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.id, id);
        params.put(DBUtils.user_id, userId);

        return parameterJdbcTemplate.queryForObject(sql, params, String.class);
    }

    /**
     * Usuwa encję o podanym identyfikatorze i identyfikatorze użytkownika.
     * @param id     Identyfikator jednostki
     * @param userId Identyfikator użytkownika skojarzony z jednostką
     * @param sql    SQL do usuwania jednostki
     */
    protected void delete(long id, long userId, String sql) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.id, id);
        params.put(DBUtils.user_id, userId);
        parameterJdbcTemplate.update(sql, params);
    }

    /**
     * Zwraca informację, czy ciąg istnieje w encji o podanym identyfikatorze i czy identyfikator użytkownika istnieje.
     * @param name   Nazwa encji
     * @param id     Identyfikator jednostki
     * @param userId Identyfikator użytkownika skojarzony z jednostką
     * @param sql    Kod SQL do wykonywania zapytań do jednostki
     * @return the boolean
     */
    protected boolean exists(String name, long id, long userId, String sql) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.name, name);
        params.put(DBUtils.id, id);
        params.put(DBUtils.user_id, userId);
        List<Long> list = parameterJdbcTemplate.queryForList(sql, params, Long.class);

        return list.size() > 0;
    }

    /**
     * Zwraca informację, czy można usunąć jednostkę o podanym identyfikatorze i identyfikatorze użytkownika.
     *
     * @param id     Identyfikator użytkownika skojarzony z jednostką
     * @param userId identyfikator użytkownika
     * @param query  Kod SQL do wykonywania zapytań do jednostki
     * @return the boolean
     */
    protected boolean canDelete(long id, long userId, String query) {
        Map<String, Object> params = new HashMap<>();
        params.put(DBUtils.id, id);
        params.put(DBUtils.user_id, userId);

        List<Long> list = parameterJdbcTemplate.queryForList(query, params, Long.class);

        if (list.size() > 0) {
            return false;
        }
        return true;
    }
}
