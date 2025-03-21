package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.entity.Task;
import com.farm_management.farm_management.service.taskService;
import com.farm_management.farm_management.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm_management.farm_management.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class taskServiceImpl implements taskService {

    @Autowired
    private taskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(new Date());
        task.setStatus(String.valueOf(Status.TODO));
        return  taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public Task getTaskById(Task task) {
        Optional<Task> task1=  taskRepository.findById(Long.valueOf(task.getId()));

        if (task1.isPresent()){
            return task1.get();
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(int task_id) {
     taskRepository.deleteById(Long.valueOf(task_id));
    }

    @Override
    public Task updateTaskStatus(int id, String status, int user_id) {
        Optional<Task> task = taskRepository.findById(Long.valueOf(id));
        if (task.isPresent()){
            Task updatedTask = task.get();
            if (updatedTask.getAssignedUser().getId() == user_id) {
                updatedTask.setUpdatedAt(new Date());
                updatedTask.setStatus(status);
                taskRepository.save(updatedTask);
            }

        }
        return null;
    }
}
