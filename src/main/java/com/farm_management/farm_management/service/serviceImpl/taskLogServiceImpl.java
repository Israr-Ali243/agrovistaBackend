package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.entity.TaskLog;
import com.farm_management.farm_management.service.taskLogService;
import com.farm_management.farm_management.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm_management.farm_management.repository.*;
import java.util.List;


@Service
public class taskLogServiceImpl implements taskLogService {
    @Autowired
    private taskLogRepository taskLogRepository;

    @Override
    public TaskLog createTaskLog(TaskLog taskLog) {
        taskLog.setNewStatus(String.valueOf(Status.TODO));
        taskLog.setOldStatus("null");
        return taskLogRepository.save(taskLog);
    }

    @Override
    public List<TaskLog> getAllTaskLogsByTaskId(int taskId) {
        return null;
    }
}
