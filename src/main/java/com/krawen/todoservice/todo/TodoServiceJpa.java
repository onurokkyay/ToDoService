package com.krawen.todoservice.todo;
import java.util.List;

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
	
	public Todo addTodo(String username, Todo todo) {
		todo.setUsername(username);
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