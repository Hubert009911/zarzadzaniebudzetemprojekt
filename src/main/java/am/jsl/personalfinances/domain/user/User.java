package am.jsl.personalfinances.domain.user;

import am.jsl.personalfinances.domain.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Obiekt domeny użytkownika, który implementuje UserDetails i będzie używany
 * Spring Security do celów bezpieczeństwa.
 */
public class User extends BaseEntity implements UserDetails {

    /**
     * Login użytkownika
     */
    private String login;

    /**
     * Hasło użytkownika
     */
    private String password;

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
     * Data ostatniego logowania użytkownika
     */
    private LocalDateTime lastLogin = null;

    /**
     * Wskazuje, czy ten użytkownik jest włączony
     */
    private boolean enabled = true;

    /**
     * Rola użytkownika
     */
    private Role role;

    /**
     * Uprawnienia użytkownika
     */
    private Set<GrantedAuthority> authorities = null;

    /**
     * Konstruktor domyślny
     */
    public User() {
        super();
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
     * Ustawia logowanie.
     *
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
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
     * Pobiera imię.
     *
     * @return Imię
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Ustawia imię.
     *
     * @param firstName Imię
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Pobiera nazwisko.
     *
     * @return nazwisko
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ustawia nazwisko.
     *
     * @param lastName nazwisko
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Pobiera adres e-mail.
     *
     * @return E-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Ustawia adres e-mail.
     *
     * @param email E-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pobiera numer telefonu
     *
     * @return numer telefonu
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Ustawia numer telefonu.
     *
     * @param phone numer telefonu
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Pobiera ostatnie logowanie.
     *
     * @return ostatnie logowanie
     */
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Ustawia ostatnie logowanie.
     *
     * @param lastLogin ostatnie logowanie
     */
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Sets włączony
     *
     * @param enabled  włączony
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Pobiera ikonę.
     *
     * @return ikona
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Ustawia ikonę.
     *
     * @param icon ikona
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter dla właściwości 'role'.
     *
     * @return Wartość dla właściwości  'role'.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter dla właściwości 'role'.
     *
     * @param role Wartość do ustawienia dla właściwości 'role'.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), login);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final User other = (User) obj;
        return Objects.equals(this.getId(), other.getId())
                && Objects.equals(this.login, other.login);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = new HashSet<>();
            authorities.add(role);
        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        //zwraca true = konto jest ważne / nie wygasło
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //zwraca true = Konto nie jest zablokowane
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //zwraca true = hasło jest prawidłowe / nie wygasło
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                '}';
    }
}
