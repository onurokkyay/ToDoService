package com.krawen.todoservice.service;

import java.time.LocalDate;
import java.util.List;

import com.krawen.todoservice.todo.Todo;

public interface ITodoService {

	List<Todo> findByUsername(String username);

	Todo addTodo(String username, String description, LocalDate targetDate, boolean done);

	void deleteById(int id);

	Todo findById(int id);

	void updateTodo(Todo todo);

}
