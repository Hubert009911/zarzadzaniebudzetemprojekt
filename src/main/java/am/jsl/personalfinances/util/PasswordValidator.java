package am.jsl.personalfinances.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PasswordValidator sprawdza poprawność haseł przy użyciu wyrażenia regularnego.
 */
public class PasswordValidator {
    private Pattern pattern;
    private Matcher matcher;

    /*
        (			            # Początek grupy
            (?=.*\d)		#   musi zawierać jedną cyfrę od 0 do 9
            (?=.*[a-z])		#   musi zawierać jedną małą literę
            (?=.*[A-Z])		#   musi zawierać jedną wielką literę
            (?=.*[@#$%])	#   musi zawierać jeden znak specjalny na liście "@#$%"
            .		        #   dopasuj wszystko do poprzedniego sprawdzania warunków
            {8,20}	        #   długość co najmniej 8 znaków i maksymalnie 20
        )			            #   Koniec grupy
    */
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    public PasswordValidator(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    /**
     * Potwierdź hasło za pomocą wyrażenia regularnego
     * @param password hasło do weryfikacji
     * @return true ważne hasło, false nieprawidłowe hasło
     */
    public boolean validate(final String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
