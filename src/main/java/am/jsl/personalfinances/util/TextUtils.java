package am.jsl.personalfinances.util;

/**
 * Definiuje metody pracy z tekstami.
 */
public class TextUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static boolean hasText(Object ob) {
		if (!(ob instanceof String)) {
			return false;
		}
		String value = (String) ob;
		return (value.trim().length() > 0);
	}

	public static boolean isEmpty(Object ob) {
		return !hasText(ob);
	}

}
