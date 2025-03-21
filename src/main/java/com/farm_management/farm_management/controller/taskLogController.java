package com.farm_management.farm_management.controller;

import com.farm_management.farm_management.entity.TaskLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farm_management.farm_management.service.*;

import java.util.List;

@RestController
@RequestMapping("/tasklog")
public class taskLogController {
    @Autowired
    private taskLogService taskLogService;


    @PostMapping("/save")
    public ResponseEntity<TaskLog> createTaskLog(@RequestBody TaskLog taskLog){
        return ResponseEntity.ok(taskLogService.createTaskLog(taskLog));
    }

    @GetMapping("/getAll/bytask/task_id/{task_id}")
    public ResponseEntity<List<TaskLog>> getAllTaskLogsByTaskId(@PathVariable("task_id") int id){
        return ResponseEntity.ok(taskLogService.getAllTaskLogsByTaskId(id));
    }
}
