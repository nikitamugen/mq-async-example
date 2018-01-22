package ru.nikitamugen.mqasyncexample.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmptyValue<E> implements ImList<E> {
    public EmptyValue() {
    }
    public ImList<E> cons(E e) {
        return new Value<>(e, this);
    }
    public E first() {
        throw new UnsupportedOperationException();
    }
    public ImList<E> rest() {
        throw new UnsupportedOperationException();
    }
    public Boolean contains(E e) {
        return false;
    }
    public ImList<E> remove(E e) {
        return this;
    }
    public List<E> toList() {
        List<E> emptyList = new LinkedList<>();
        return Collections.unmodifiableList(emptyList);
    }
    public void addToList(List<E> l) {
    }

}