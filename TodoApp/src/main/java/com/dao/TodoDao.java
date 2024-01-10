package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.controller.Student;
import com.entities.Todo;

@Repository
public class TodoDao {
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveTodo(Todo todo) {
		int id = (Integer) this.hibernateTemplate.save(todo);
		return id;
	}
	
	public List<Todo> getTodos() {
		List<Todo> todos = this.hibernateTemplate.loadAll(Todo.class);
		return todos;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
