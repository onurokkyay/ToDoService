package com.krawen.todoservice.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krawen.todoservice.repository.TodoRepository;
import com.krawen.todoservice.service.ITodoService;

@Service("TodoServiceJpa")
public class TodoServiceJpa implements ITodoService {
	
	@Autowired
	TodoRepository todoRepo;
	
	public List<Todo> findByUsername(String username){
		return todoRepo.findByUsername(username);
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(10,username,description,targetDate,done);
		todoRepo.save(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		todoRepo.deleteById(id);
	}

	public Todo findById(int id) {
		return todoRepo.findById(id).orElse(null);
	}

	public void updateTodo(Todo todo) {
		todoRepo.save(todo);
	}
}