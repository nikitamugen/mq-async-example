package ru.nikitamugen.mqasyncexample.model;

import java.util.List;

public interface ImList<E> {
    public ImList<E> cons(E e);
    public E first();
    public ImList<E> rest();
    public Boolean contains(E e);
    public ImList<E> remove(E e);
    public List<E> toList();
    public void addToList(List<E> l);
}
