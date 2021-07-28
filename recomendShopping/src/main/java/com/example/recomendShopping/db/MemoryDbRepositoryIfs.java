package com.example.recomendShopping.db;
import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs <T> {
    Optional<T> findById(Integer idx);
    T save(T entity);
    void deleteById(Integer idx);
    List<T> findAll();
}