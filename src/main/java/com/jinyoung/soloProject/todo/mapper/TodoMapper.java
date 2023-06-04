package com.jinyoung.soloProject.todo.mapper;

import com.jinyoung.soloProject.todo.dto.PatchTodoDto;
import com.jinyoung.soloProject.todo.dto.PostTodoDto;
import com.jinyoung.soloProject.todo.dto.ResponseTodoDto;
import com.jinyoung.soloProject.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo todoPostToTodo(PostTodoDto postTodoDto);

    Todo todoPatchToTodo(PatchTodoDto patchTodoDto);

    ResponseTodoDto todoToResponseTodo(Todo todo);

    List<ResponseTodoDto> todosToResponseTodos(List<Todo> todos);
}
