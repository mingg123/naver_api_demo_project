package com.example.recomendShopping.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.var;

public class MemoryDbRepositoryAbstract < T extends MemoryDbEntity > implements MemoryDbRepositoryIfs<T> {
    private final List<T> db = new ArrayList<>();
    private Integer index = 0;

    @Override public Optional<T> findById(Integer idx) {
        return db
            .stream()
            .filter(it -> it.getIndex() == idx)
            .findFirst();

    }
    @Override public T save(T entity) {
        var optionalEntity = db
            .stream()
            .filter(it -> it.getIndex() == entity.getIndex())
            .findFirst();

        if (optionalEntity.isEmpty()) {
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        } else {
            var preIndex = optionalEntity
                .get()
                .getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override public void deleteById(Integer idx) {
        var optionalEntity = db
            .stream()
            .filter(it -> it.getIndex() == index)
            .findFirst();
        if (optionalEntity.isPresent()) {
            db.remove(optionalEntity.get());
        }

    }
    @Override public List<T> findAll() {
        return db;
    }

}
