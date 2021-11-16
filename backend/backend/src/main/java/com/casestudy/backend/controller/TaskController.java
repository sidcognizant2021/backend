package com.casestudy.backend.controller;

import com.casestudy.backend.model.Tasks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//by team 1
@RestController
@RequestMapping("/tasks")
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
