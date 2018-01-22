package ru.nikitamugen.mqasyncexample.api.request;

import java.io.Serializable;

public interface WordRequest extends Serializable {
    WordRequestTypes getType();

    public static WordRequest createAddWord(String code, String value) {
        AddWord request = new AddWord();
        request.setCode(code);
        request.setValue(value);
        return request;
    }

    public static WordRequest createDeleteWord(String code, String value) {
        DeleteWord request = new DeleteWord();
        request.setCode(code);
        request.setValue(value);
        return request;
    }

    public static WordRequest createGetWord(String code) {
        GetWord request = new GetWord();
        request.setCode(code);
        return request;
    }
}
