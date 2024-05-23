package com.makar.TaskManagementSystemAPI.repository;

import com.makar.TaskManagementSystemAPI.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTaskByUserId(Long user_id);
}
