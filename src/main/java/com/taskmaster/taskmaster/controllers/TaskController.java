package com.taskmaster.taskmaster.controllers;


import com.taskmaster.taskmaster.models.Task;
import com.taskmaster.taskmaster.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getCustomers() {
        return (List) taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public void addNewUser (@RequestBody Task task) {
        Task t = new Task();
        t.setDescription(task.getDescription());
        t.setStatus("Available");
        t.setTitle(task.getTitle());
        taskRepository.save(t);
    }

    @PutMapping("/tasks/{id}/status")
    public Task updateTaskStatus(@PathVariable String id) {
        Task t = taskRepository.findById(id).get();
        if (t.getStatus().equals("Available")) {
            t.setStatus("Assigned");
        } else if (t.getStatus().equals("Assigned")) {
            t.setStatus("Accepted");
        } else if (t.getStatus().equals("Accepted")) {
            t.setStatus("Finished");
        }
        taskRepository.save(t);
        return t;
    }
}