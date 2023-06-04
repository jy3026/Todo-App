package com.jinyoung.soloProject.todo.dto;

import lombok.Getter;

@Getter
public class PatchTodoDto {

    private long id;
    private String title;
    private int todo_order;
    private boolean completed;

    public void setId(long id) {
        this.id = id;
    }
}
