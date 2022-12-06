package am.jsl.personalfinances.dto.user;

import am.jsl.personalfinances.domain.user.Role;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.util.Constants;
import am.jsl.personalfinances.util.TextUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Typ User dto.
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 8416849345869102122L;

    /**
     * Wewnętrzny identyfikator
     */
    private long id;

    /**
     * Login użytkownika
     */
    private String login;

    /**
     * Imię użytkownika
     */
    private String firstName;

    /**
     * Nazwisko użytkownika
     */
    private String lastName;

    /**
     * Adres e-mail użytkownika
     */
    private String email;

    /**
     * Telefon użytkownika
     */
    private String phone;

    /**
     * Ikona użytkownika
     */
    private String icon = null;

    /**
     * Hasło użytkownika
     */
    private String password;

    /**
     * Użytkownik potwierdza hasło
     */
    private String confirmPassword;

    /**
     * Wskazuje, czy ten użytkownik jest włączony
     */
    private boolean enabled;

    /**
     * Rola tego użytkownika
     */
    private Role role;

    /**
     * Data ostatniego logowania
     */
    private LocalDateTime lastLogin = null;

    /**
     * Pobiera identyfikator.
     *
     * @return identyfikator
     */
    public long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator.
     *
     * @param id identyfikator
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Pobiera login.
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Ustawia login.
     *
     * @param login  login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Pobiera imię.
     *
     * @return imię
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Ustawia imię.
     *
     * @param firstName the imię
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Pobiera Naziwsko.
     *
     * @return Naziwsko
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ustawia Naziwsko.
     *
     * @param lastName Naziwsko
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Pobiera email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Ustawia email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pobiera phone.
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Ustawia phone.
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Pobiera icon.
     *
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Ustawia icon.
     *
     * @param icon icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Pobiera hasło.
     *
     * @return hasło
     */
    public String getPassword() {
        return password;
    }

    /**
     * Ustawia hasło.
     *
     * @param password hasło
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Pobiera Potwierdź hasło.
     *
     * @return Potwierdź hasło
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Ustawia Potwierdź hasło.
     *
     * @param confirmPassword Potwierdź hasło
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Jest włączona boolean.
     *
     * @return boolean
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Ustawia enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Pobiera role.
     *
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Ustawia role.
     *
     * @param role role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Pobiera Ostatnie logowanie.
     *
     * @return Ostatnie logowanie.
     */
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Ustawia Ostatnie logowanie.
     *
     * @param lastLogin Ostatnie logowanie.
     */
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Zwróć pełną ścieżkę ikony użytkownika.
     *
     * @return Ścieżka ikony
     */
    public String getIconPath() {
        if (!TextUtils.isEmpty(icon)) {
            StringBuilder path = new StringBuilder();
            path.append(Constants.USER_IMG_PATH).append(id);
            path.append(Constants.SLASH).append(icon);
            return path.toString();
        }
        return Constants.USER_PROFILE_DEFAULT_IMG;
    }

    /**
     * Tworzy obiekt DTO użytkownika z obiektu domeny użytkownika.
     *
     * @param user  User
     * @return  UserDTO
     */
    public static UserDTO from(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setIcon(user.getIcon());
        userDTO.setEnabled(user.isEnabled());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    /**
     * Konwertuje to dto użytkownika na obiekt domeny użytkownika.
     *
     * @return Obiekt domeny użytkownika
     */
    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setIcon(icon);
        user.setEnabled(enabled);
        user.setRole(role);
        return user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final UserDTO other = (UserDTO) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.login, other.login)
                && Objects.equals(this.email, other.email);
    }
}
