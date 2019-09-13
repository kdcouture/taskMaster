package com.marishaoza.taskmaster.Controllers;


import com.marishaoza.taskmaster.Models.HistoryObj;
import com.marishaoza.taskmaster.Models.Task;
import com.marishaoza.taskmaster.Repository.S3Client;
import com.marishaoza.taskmaster.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskController {

    private S3Client s3Client;

    @Autowired
    TaskController(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return (List) taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task addNewTask (@RequestBody Task task) {
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus("Available");
        newTask.addHistory(new HistoryObj("Task created"));
        taskRepository.save(newTask);
        return newTask;
    }

    @PostMapping("/tasks/img")
    public Task addImgToTask(@RequestParam("id") String id, @RequestPart("file") MultipartFile file) {
        Task t = taskRepository.findById(id).get();
        String img = this.s3Client.uploadFile(file);
        t.setPic(img);
        taskRepository.save(t);
        return t;
    }

    @PutMapping("/tasks/{id}/state")
    public Task updateTaskStatus (@PathVariable String id) {
        Task taskToUpdate = taskRepository.findById(id).get();
        if (taskToUpdate.getStatus().equals("Available")) {
            taskToUpdate.setStatus("Assigned");
        } else if (taskToUpdate.getStatus().equals("Assigned")) {
            taskToUpdate.setStatus("Accepted");
        } else if (taskToUpdate.getStatus().equals("Accepted")) {
            taskToUpdate.setStatus("Finished");
        } else if (taskToUpdate.getStatus().equals("Finished")) {
            return taskToUpdate;
        }
        taskToUpdate.addHistory(new HistoryObj("--> " + taskToUpdate.getStatus()));
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }

    @GetMapping("/users/{name}/tasks")
    public List<Task> getTasksByAssignee(@PathVariable String name) {
        return (List) taskRepository.findAllByAssignee(name).get();
    }

    @PutMapping("/tasks/{id}/assign/{assignee}")
    public Task updateTaskAssignee(@PathVariable String id, @PathVariable String assignee) {
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setAssignee(assignee);
        taskToUpdate.setStatus("Assigned");
        taskToUpdate.addHistory(new HistoryObj("--> Assigned to " + assignee));
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }
}
