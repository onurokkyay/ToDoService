package com.krawen.todoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.krawen.todoservice.todo.Todo;
import com.krawen.todoservice.todo.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/users/{userName}/todos")
	public List<Todo> retrieveTodos(@PathVariable String userName) {
		return todoService.findByUsername(userName);
	}

}
