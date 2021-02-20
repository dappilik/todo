package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAll(){
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Todo> add(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
          return todoService.delete(id);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAll(){
        return todoService.deleteAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@RequestBody Todo todo, @PathVariable Long id){
        return todoService.update(todo, id);
    }


}
