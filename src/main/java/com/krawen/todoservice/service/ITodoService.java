package com.krawen.todoservice.service;

import java.util.List;

import com.krawen.todoservice.todo.Todo;

public interface ITodoService {

	List<Todo> findByUsername(String username);

	void deleteById(int id);

	Todo findById(int id);

	void updateTodo(Todo todo);

	Todo addTodo(String userName, Todo todo);

}
