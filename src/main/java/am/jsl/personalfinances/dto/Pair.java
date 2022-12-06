package am.jsl.personalfinances.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Klasa 'Pair' służy do przechowywania sparametryzowanych par klucz-wartość.
 */
public class Pair<K, V> implements Serializable {
    private K key = null;
    private V value = null;

    /**
     * Konstrukcja domyślna.
     */
    public Pair() {
    }

    /**
     * Konstruuje nowe pary z danym kluczem i wartością.
     * @param key Klucz parametryczny
     * @param value wartość parametryczna
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter dla właściwości 'key'.
     *
     * @return Wartość dla właściwości 'key'.
     */
    public K getKey() {
        return key;
    }

    /**
     * Setter dla właściwości 'key'.
     *
     * @param key Wartość do ustawienia dla właściwości 'key'.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Getter dla właściwości 'value'.
     *
     * @return Wartość dla właściwości 'value'.
     */
    public V getValue() {
        return value;
    }

    /**
     * Setter dla właściwości 'value'.
     *
     * @param value Wartość do ustawienia dla właściwości 'value'.
     */
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        return Objects.equals(this.key, other.key)
                && Objects.equals(this.value, other.value);
    }
}
