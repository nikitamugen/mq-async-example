package ru.nikitamugen.mqasyncexample.model;

public class EmptyKey<E, V> implements ImDictionary<E, V> {
    public EmptyKey() {
    }
    public ImDictionary<E, V> key(E e) {
        return new Key<>(e, this);
    }
    public E first() {
        throw new UnsupportedOperationException();
    }
    public ImList<E> rest() {
        throw new UnsupportedOperationException();
    }
    public ImDictionary<E, V> keys() {
        throw new UnsupportedOperationException();
    }
    public ImDictionary<E, V> find(E e) {
        return new EmptyKey<>();
    }
    public Boolean contains(E e) {
        return false;
    }
    public Boolean isEmpty() {
        return true;
    }

    public ImDictionary<E, V> value(V v) {
        throw new UnsupportedOperationException();
    }
    public ImList<V> values() {
        throw new UnsupportedOperationException();
    }
    public Boolean hasValue(V v) {
        return false;
    }
    public ImDictionary<E, V> removeValue(V v) {
        throw new UnsupportedOperationException();
    }
}
