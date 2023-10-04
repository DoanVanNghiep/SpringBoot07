package com.vn.devmaster.services.mapper;

import java.util.List;

public interface EntityMapper<E, D>{
    E toEntity(D d);
    List<E> toEntity(List<D> d);
    D toDO(E e);
    List<D> toDO(List<E> e);
}
