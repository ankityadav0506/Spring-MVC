package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TodoDao;
import com.entities.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoDao todoDao;
	
	public int createTodo(Todo todo) {
		return this.todoDao.saveTodo(todo);
	}
	
	public List<Todo> getTodos() {
		return this.todoDao.getTodos();
	}
}
