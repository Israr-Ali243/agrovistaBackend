package com.farm_management.farm_management.service;

import com.farm_management.farm_management.entity.TaskLog;

import java.util.List;

public interface taskLogService {
    TaskLog createTaskLog(TaskLog taskLog);
    List<TaskLog> getAllTaskLogsByTaskId(int taskId);
}
