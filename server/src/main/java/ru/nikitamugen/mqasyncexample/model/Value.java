package ru.nikitamugen.mqasyncexample.model;

import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Value<E extends Object> implements ImList<E> {
    private final E e;
    private final ImList<E> rest;

    public Value(E e, ImList<E> rest) {
        this.e = e;
        this.rest = rest;
    }
    public ImList<E> cons(E e) {
        return new Value<>(e, this);
    }
    public E first() {
        return e;
    }
    public ImList<E> rest() {
        return rest;
    }
    public Boolean contains(E e) {
        if (this.e.equals(e)) {
            return true;
        }
        return rest.contains(e);
    }
    public ImList<E> remove(E e) {
        if (this.e.equals(e)) {
            return rest.remove(e);
        }
        return new Value<>(this.e, rest.remove(e));
    }

    public List<E> toList() {
        List<E> tmp = new LinkedList<>();
        addToList(tmp);

        return Collections.unmodifiableList(tmp);
    }

    public void addToList(List<E> l) {
        Assert.notNull(l, "List destination is null");

        l.add(e);
        rest.addToList(l);
    }
}
