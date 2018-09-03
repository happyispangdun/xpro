package com.syl.dao;

import java.util.List;

public interface BaseDao<T> {

    int save(T t);

    int edit(T t);

    int delete(String id);

    T findById(String id);

    List<T> findByAll();
}
