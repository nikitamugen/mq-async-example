package ru.nikitamugen.mqasyncexample.api.request;

import java.util.Objects;

public class DeleteWord implements WordRequest {
    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass())
            return false;
        DeleteWord message = (DeleteWord) object;
        return (this.hashCode() == message.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, value);
    }

    @Override
    public String toString() {
        return "DeleteWord{" +
                "code='" + code + '\'' +
                ", names=" + value +
                '}';
    }

    @Override
    public WordRequestTypes getType() {
        return WordRequestTypes.DELETE;
    }
}
