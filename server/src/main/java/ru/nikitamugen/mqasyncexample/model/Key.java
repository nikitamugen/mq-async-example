package ru.nikitamugen.mqasyncexample.model;

public class Key<E extends Object, V extends Object> implements ImDictionary<E, V> {
    private final E key;
    private final ImDictionary<E, V> rest;
    private ImList<V> values;

    public Key(E key, ImDictionary<E, V> rest) {
        this.key = key;
        this.rest = rest;
        this.values = new EmptyValue<>();
    }
    public ImDictionary<E, V> key(E e) {
        return new Key<>(e, this);
    }
    public ImDictionary<E, V> keys() {
        return rest;
    }
    public ImDictionary<E, V> find(E e) {
        if (this.key.equals(e)) {
            return this;
        }
        return rest.find(e);
    }
    public Boolean contains(E e) {
        return null;
    }
    public E first() {
        return key;
    }
    public Boolean isEmpty() {
        return false;
    }

    public ImDictionary<E, V> value(V v) {
        values = values.cons(v);
        return this;
    }
    public ImList<V> values() {
        return values;
    }
    public Boolean hasValue(V v) {
        return values.contains(v);
    }
    public ImDictionary<E, V> removeValue(V v) {
        values = values.remove(v);
        return this;
    }
}
