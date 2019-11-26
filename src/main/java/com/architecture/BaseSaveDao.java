package com.architecture;

public interface BaseSaveDao<T> {
    void save(T object);
}
