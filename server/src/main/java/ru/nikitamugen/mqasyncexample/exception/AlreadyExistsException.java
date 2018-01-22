package ru.nikitamugen.mqasyncexample.exception;

public class AlreadyExistsException extends Exception {

    private static final String format =
            "<слово '%s' со значением '%s' уже существует>";

    private final String key;
    private final String value;

    public AlreadyExistsException(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return String.format(format, key, value);
    }
}
