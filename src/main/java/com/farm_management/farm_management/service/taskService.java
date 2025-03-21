package com.farm_management.farm_management.service;

import com.farm_management.farm_management.entity.Task;

import java.util.List;

public interface taskService {
    Task createTask (Task task);
    Task updateTask(Task task);
    Task getTaskById(Task task);
    List<Task> getAllTasks();
    void  deleteTask(int task_id);
    Task updateTaskStatus(int id, String status, int user_id);
}
