package com.casestudy.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.backend.model.Tasks;
import com.casestudy.backend.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/tasks/{id}")
	public Tasks getTaskbyId(@PathVariable("id") int id) {
		Optional<Tasks> tasks = taskRepository.findById(id);
		if (tasks.isPresent()) {
			return tasks.get();
		} else {
			return null;
		}
	}

	@GetMapping("/tasks")
	public List<Tasks> getAllTasks() {
		List<Tasks> tasks = new ArrayList<Tasks>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
}