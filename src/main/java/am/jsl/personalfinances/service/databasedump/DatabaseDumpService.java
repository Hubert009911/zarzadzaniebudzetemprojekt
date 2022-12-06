package am.jsl.personalfinances.service.databasedump;

/**
 * Interfejs serwisowy, który definiuje metodę zrzutu bazy danych w określonym folderze.
 */
public interface DatabaseDumpService {

	/**
	 * Zrzuca bazę danych w określonym folderze i kompresuje plik zrzutu.
	 */
	void dumpDatabase();
}
