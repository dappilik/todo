package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {

    ResponseEntity<Todo> save(Todo todo);

    ResponseEntity<List<Todo>> getAll();

    ResponseEntity<String> delete(Long id);

    ResponseEntity<Todo> update(Todo todo, Long id);

    ResponseEntity<Todo> getTodoById(Long id);

    ResponseEntity<String> deleteAll();
}
