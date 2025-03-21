package com.farm_management.farm_management.repository;

import com.farm_management.farm_management.entity.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskLogRepository extends JpaRepository<TaskLog, Long> {
}
