package com.itheima.em.sdk.service;

public interface Function<T, E> {

    T callback(E e);

}