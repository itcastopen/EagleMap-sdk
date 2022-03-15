package cn.itcast.em.sdk.service;

public interface Function<T, E> {

    T callback(E e);

}