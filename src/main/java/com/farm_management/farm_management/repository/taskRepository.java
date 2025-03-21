package com.farm_management.farm_management.repository;

import com.farm_management.farm_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository<Task, Long> {
}
