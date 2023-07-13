package com.krawen.todoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krawen.todoservice.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUsername(String username);
}
