package ru.nikitamugen.mqasyncexample.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitamugen.mqasyncexample.exception.AlreadyExistsException;
import ru.nikitamugen.mqasyncexample.exception.KeyNotFoundException;
import ru.nikitamugen.mqasyncexample.exception.KeyOrValueNotFoundException;
import ru.nikitamugen.mqasyncexample.model.ImDictionary;

import java.util.List;

@Service
public class WordsService {

    private static Logger logger = Logger.getLogger(WordsService.class);

    @Autowired
    ImDictionary<String, String> words;

    public void add(String key, String value) throws AlreadyExistsException {
        ImDictionary<String, String> current = words.find(key);
        if (current.isEmpty()) {
            words = words.key(key).value(value);
        } else if (current.values().contains(value)) {
            throw new AlreadyExistsException(key, value);
        } else {
            current.value(value);
        }
    }

    public void remove(String key, String value) throws KeyOrValueNotFoundException, KeyNotFoundException {
        ImDictionary<String, String> current = words.find(key);
        if (current.isEmpty()) {
            throw new KeyNotFoundException(key);
        } else if (!current.values().contains(value)) {
            throw new KeyOrValueNotFoundException(key, value);
        }
        current.removeValue(value);
    }

    public List<String> get(String key) throws KeyNotFoundException {
        ImDictionary<String, String> current = words.find(key);
        if (current.isEmpty()) {
            throw new KeyNotFoundException(key);
        }
        return current.values().toList();
    }
}
