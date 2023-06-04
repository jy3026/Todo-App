package com.jinyoung.soloProject.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTodoDto {

    private int id;

    private String title;

    private int todo_order;

    private boolean completed;
}
