package ru.nikitamugen.mqasyncexample.api.request;

import java.util.Objects;

public class GetWord implements WordRequest {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass())
            return false;
        GetWord message = (GetWord) object;
        return (this.hashCode() == message.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "GetWord{" +
                "code='" + code +
                '}';
    }

    @Override
    public WordRequestTypes getType() {
        return WordRequestTypes.GET;
    }
}
