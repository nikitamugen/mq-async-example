package ru.nikitamugen.mqasyncexample.model;

import java.util.List;

public interface ImDictionary<E, V> {
    public ImDictionary<E, V> key(E e);
    public ImDictionary<E, V> keys();
    public ImDictionary<E, V> find(E e);
    public Boolean contains(E e);
    public E first();
    public Boolean isEmpty();

    public ImDictionary<E, V> value(V v);
    public ImList<V> values();
    public Boolean hasValue(V v);
    public ImDictionary<E, V> removeValue(V v);
}
