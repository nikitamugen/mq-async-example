package ru.nikitamugen.mqasyncexample.api.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public interface WordRequest extends Serializable {
    WordRequestTypes getType();

    static Logger logger = Logger.getLogger(WordRequest.class);

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

    public static WordRequest createFromJsonString(String jsonString) {
        Assert.hasText(jsonString, "jsonString is empty");

        WordRequest request = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> objectMap =
                    objectMapper.readValue(jsonString, new TypeReference<Map<String, String>>() {
                    });
            String typeString = objectMap.get("type");
            WordRequestTypes type = WordRequestTypes.valueOf(typeString);
            switch (type) {
                case ADD:
                    request = createAddWord(objectMap.get("code"), objectMap.get("value"));
                    break;
                case DELETE:
                    request = createDeleteWord(objectMap.get("code"), objectMap.get("value"));
                    break;
                case GET:
                    request = createGetWord(objectMap.get("code"));
                    break;
                default:
                    throw new UnsupportedOperationException("Operation with request type " + typeString + " is unsupported.");
            }
        } catch (IOException ex) {
            logger.error(ex);
        }

        return request;
    }
}
