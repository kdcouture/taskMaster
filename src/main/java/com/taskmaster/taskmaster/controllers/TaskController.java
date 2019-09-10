package com.taskmaster.taskmaster.controllers;


import com.taskmaster.taskmaster.models.Task;
import com.taskmaster.taskmaster.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/tasks/{id}/status")
    public String getTaskIdStatus(@PathVariable String id) {
        Task temp = taskRepository.findById(id).get();
        if(temp != null) {
            return temp.getStatus();
        }
        else {
            return "No task with given ID";
        }
    }
}