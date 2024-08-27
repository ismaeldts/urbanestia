package com.urbanestia.property.shared;

import java.util.List;

public interface EntityToDto<E, O> {

    O toDto(E e);

    E toEntity(O o);

    List<O> toDto(List<E> e);

    List<E> toEntity(List<O> o);

}
