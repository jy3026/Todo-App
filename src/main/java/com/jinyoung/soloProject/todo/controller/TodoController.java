package com.jinyoung.soloProject.todo.controller;

import com.jinyoung.soloProject.todo.dto.PatchTodoDto;
import com.jinyoung.soloProject.todo.dto.PostTodoDto;
import com.jinyoung.soloProject.todo.entity.Todo;
import com.jinyoung.soloProject.todo.mapper.TodoMapper;
import com.jinyoung.soloProject.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity postTodo(@RequestBody PostTodoDto postTodoDto) {

        Todo todo = todoService.createTodo(mapper.todoPostToTodo(postTodoDto));

        return new ResponseEntity<>(mapper.todoToResponseTodo(todo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable("id") Long id){

        Todo todo = todoService.findTodo(id);

        return new ResponseEntity<>(mapper.todoToResponseTodo(todo),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(){

        List<Todo> todos = todoService.findTodos();

        return new ResponseEntity<>(mapper.todosToResponseTodos(todos),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@PathVariable("id") Long id,
                                    @RequestBody PatchTodoDto patchTodoDto){
        patchTodoDto.setId(id);
        Todo todo = todoService.updateTodo(mapper.todoPatchToTodo(patchTodoDto));

        return new ResponseEntity<>(mapper.todoToResponseTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") Long id){

        todoService.removeTodo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
