package com.jinyoung.soloProject.todo.dto;

import lombok.Getter;

@Getter
public class PostTodoDto {

    private String title;

    private int todo_order;

    private boolean completed;
}
