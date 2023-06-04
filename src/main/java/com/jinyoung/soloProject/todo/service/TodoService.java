package com.jinyoung.soloProject.todo.service;


import com.jinyoung.soloProject.todo.entity.Todo;
import com.jinyoung.soloProject.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo findTodo(long id){

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        return optionalTodo.orElseThrow();


    }

    public List<Todo> findTodos(){


        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
        Todo findTodo = verifyTodo(todo.getId());

        Optional.ofNullable(todo.getTitle()).ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodo_order()).ifPresent(todoOrder -> findTodo.setTodo_order(todoOrder));
        Optional.ofNullable(todo.getCompleted()).ifPresent(complete -> findTodo.setCompleted(complete));

        return todoRepository.save(findTodo);


    }

    public void removeTodo(long id){
        Todo todo = verifyTodo(id);

        todoRepository.delete(todo);
    }

    private Todo verifyTodo(long id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElseThrow();
    }
}
