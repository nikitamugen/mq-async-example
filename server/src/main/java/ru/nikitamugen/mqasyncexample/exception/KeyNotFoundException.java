package ru.nikitamugen.mqasyncexample.exception;

public class KeyNotFoundException extends Exception {
    private static final String format =
            "<слово ('%s') отсутвует в словаре>";

    private final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }

    @Override
    public String getMessage() {
        return String.format(format, key);
    }
}
