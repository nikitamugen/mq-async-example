package ru.nikitamugen.mqasyncexample;

import org.junit.Assert;
import org.junit.Test;
import ru.nikitamugen.mqasyncexample.model.*;

public class DictionaryTest extends Assert {

    @Test
    public void testImList() {
        ImList<String> list = new EmptyValue<String>()
                .cons("one")
                .cons("two")
                .cons("three");

        assertTrue(list.contains("one"));
        assertTrue(list.contains("two"));
        assertTrue(list.contains("three"));
        assertFalse(list.contains("nope"));

        list = list.remove("one");
        assertFalse(list.contains("one"));
        assertTrue(list.contains("two"));
        assertTrue(list.contains("three"));
        assertFalse(list.contains("nope"));
    }

    @Test
    public void testImDictionary() {
        ImDictionary<String, String> dictionary = new EmptyKey<String, String>()
                .key("one").value("a").value("b")
                .key("two").value("c").value("d");

        assertTrue(dictionary.contains("one"));
        assertTrue(dictionary.find("one").hasValue("a"));
        assertTrue(dictionary.find("one").hasValue("b"));
        assertFalse(dictionary.find("one").hasValue("nope"));
        assertTrue(dictionary.contains("two"));
        assertTrue(dictionary.find("two").hasValue("c"));
        assertTrue(dictionary.find("two").hasValue("d"));
        assertFalse(dictionary.find("two").hasValue("nope"));

        dictionary.find("one").removeValue("a");
        dictionary.find("two").removeValue("d");
        assertFalse(dictionary.find("one").hasValue("a"));
        assertTrue(dictionary.find("one").hasValue("b"));
        assertFalse(dictionary.find("one").hasValue("nope"));
        assertTrue(dictionary.find("two").hasValue("c"));
        assertFalse(dictionary.find("two").hasValue("d"));
        assertFalse(dictionary.find("two").hasValue("nope"));
    }
}
