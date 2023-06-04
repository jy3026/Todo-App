package com.jinyoung.soloProject.todo.repository;

import com.jinyoung.soloProject.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
