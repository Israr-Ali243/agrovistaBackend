package com.farm_management.farm_management.repository;

import com.farm_management.farm_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository  extends JpaRepository<User, Long> {
}
