package com.owt.owtbackend.models;

//potentially add in import com.fasterxml.jackson.annotation.JsonTypeId; ??

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class abstractEntity {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    private int id;

    public int getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        abstractEntity entity = (abstractEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);}
}