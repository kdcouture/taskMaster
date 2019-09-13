package com.marishaoza.taskmaster.Repository;

import com.marishaoza.taskmaster.Models.Task;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;


@EnableScan
public interface TaskRepository extends CrudRepository<Task, String> {
    Optional<Task> findById(String id);
    Optional<ArrayList<Task>> findAllByAssignee(String assignee);
}