package am.jsl.personalfinances.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Klasa bazowa z obsługą JDBC Dao firmy Springframework.
 * Wymaga {@link javax.sql.DataSource} do ustawienia.
 */
public class AbstractDaoImpl extends JdbcDaoSupport {

	/**
	 * Zezwalanie na użycie nazwanych parametrów
	 */
	protected NamedParameterJdbcTemplate parameterJdbcTemplate;

	/**
	 * Tworzy nowy AbstractDaoImpl dla danego {@link DataSource}.
	 * @param dataSource źródło danych JDBC, aby uzyskać dostęp
	 */
	public AbstractDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
		parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
}
