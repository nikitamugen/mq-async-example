package ru.nikitamugen.mqasyncexample.exception;

public class KeyOrValueNotFoundException extends Exception {

    private static final String format =
            "<слово ('%s') / значение ('%s') отсутвует в словаре>";

    private final String key;
    private final String value;

    public KeyOrValueNotFoundException(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return String.format(format, key, value);
    }
}
