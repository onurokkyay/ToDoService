package com.krawen.todoservice.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.krawen.todoservice.service.ITodoService;

@Service
public class TodoService implements ITodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "onurokkyay","Get AWS Certified", 
							LocalDate.now().plusYears(10), false ));
		todos.add(new Todo(++todosCount, "onurokkyay","Learn DevOps", 
				LocalDate.now().plusYears(11), false ));
		todos.add(new Todo(++todosCount, "onurokkyay","Learn Full Stack Development", 
				LocalDate.now().plusYears(12), false ));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, Todo todo) {
		todo.setUsername(username);
		todo.setId(++todosCount);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}