package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.Todo;
import com.service.TodoService;
import com.spring.orm.entities.Student;

import jakarta.servlet.ServletContext;

@Controller
public class TodoController {
	@Autowired
	ServletContext context;
	
	@Autowired
	private TodoService todoService;;
	
	@RequestMapping("/home")
	public String home(Model m) {
		String str = "home";
		m.addAttribute("page", str);
		
		List<Todo> list = (List<Todo>) context.getAttribute("list");
		m.addAttribute("todos", list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		Todo t = new Todo();
		m.addAttribute("page", "add");
		m.addAttribute("todo", t);
		return "addTodo";	
	}

//	//using spring form model attribute
	@RequestMapping(value="/saveTodo", method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo,Model m) {
		todo.setDate(new Date());
		this.todoService.createTodo(todo);
		if(todo.getTodoTitle().isBlank()) {
			m.addAttribute("msg", "title cannot be empty...");
			return "redirect:/add";
		}
//		List<Todo> list = (List<Todo>) context.getAttribute("list");
//		list.add(t);
		m.addAttribute("msg", "Todo added...");
		return "addTodo";
	}
	
	@RequestMapping("/viewTodo")
	public String viewTodo(Model m) {
		List<Todo> todos = this.todoService.getTodos();
//		List<Todo> list = (List<Todo>) context.getAttribute("list");
		m.addAttribute("todos", todos);
		return "viewTodo";
	}
	
}
