package com.krawen.todoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krawen.todoservice.service.ITodoService;
import com.krawen.todoservice.todo.Todo;

@RestController
public class TodoController {

	@Autowired
	@Qualifier("TodoServiceJpa")
	private ITodoService todoService;

	@GetMapping("/users/{userName}/todos")
	public List<Todo> retrieveTodos(@PathVariable String userName) {
		return todoService.findByUsername(userName);
	}

	@GetMapping("/users/{userName}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String userName, @PathVariable int id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable String userName, @PathVariable int id) {
		todoService.deleteById(id);
		return ResponseEntity.ok("Deleted");
	}

	@PutMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<String> updateTodo(@PathVariable String userName, @PathVariable int id,
			@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return ResponseEntity.ok("Updated");
	}

	@PostMapping("/users/{userName}/todos")
	public Todo createTodo(@PathVariable String userName, @RequestBody Todo todo) {
		return todoService.addTodo(userName, todo);
	}

}
