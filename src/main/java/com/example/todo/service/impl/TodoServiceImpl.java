package com.example.todo.service.impl;

import com.example.todo.dao.TodoRepository;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<Todo> save(Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }

    @Override
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<Todo> update(Todo todo, Long id) {
        Optional<Todo> todoToUpdateOptional = todoRepository.findById(id);
        if (todoToUpdateOptional.isPresent()) {
            Todo todoToUpdate = todoToUpdateOptional.get();
            todoToUpdate.setDescription(todo.getDescription());
            todoToUpdate.setName(todo.getName());
            return ResponseEntity.ok(todoRepository.save(todoToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<Todo> getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        todoRepository.deleteAll();
        return ResponseEntity.ok("Deleted successfully");
    }
}
