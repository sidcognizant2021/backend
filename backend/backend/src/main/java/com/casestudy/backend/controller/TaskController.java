package com.casestudy.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Tasks> getAllTasks(@RequestParam(required = false) Integer parent,
			@RequestParam(required = false) Boolean isproject) {
		List<Tasks> tasks = new ArrayList<Tasks>();
		if (parent != null) {
			taskRepository.findByParent(parent).forEach(tasks::add);
		} else if (isproject != null) {
			taskRepository.findByIsProject(isproject).forEach(tasks::add);
		} else {
			taskRepository.findAll().forEach(tasks::add);
		}
		return tasks;
	}
	
	@PostMapping("/tasks")
	public Tasks createTasks(@RequestBody Tasks tasks) {
		try {
			return taskRepository.save(tasks);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PutMapping("/tasks/{id}")
	public HttpStatus updateTasks(@PathVariable("id") int id, @RequestBody Tasks reqTasks) {
		Optional<Tasks> tasks = taskRepository.findById(id);

		if (tasks.isPresent()) {
			Tasks obj = tasks.get();
			obj.setTitle(reqTasks.getTitle());
			obj.setDetails(reqTasks.getDetails());
			obj.setWhen(reqTasks.getWhen());
			obj.setDeadline(reqTasks.getDeadline());
			obj.setProject(reqTasks.isProject());
			obj.setParent(reqTasks.getParent());
			obj.setDone(reqTasks.isDone());
						
			taskRepository.save(obj);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@DeleteMapping("/tasks/{id}")
	public HttpStatus deleteTask(@PathVariable("id") int id) {
			taskRepository.deleteById(id);
			return HttpStatus.OK;
	}
}
