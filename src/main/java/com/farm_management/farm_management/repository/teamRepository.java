package com.farm_management.farm_management.repository;

import com.farm_management.farm_management.entity.Team;
import com.farm_management.farm_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface teamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT tm.user FROM TeamMember tm WHERE tm.team.id = :teamId")
    List<User> findUsersByTeamId(@Param("teamId") Long teamId);
}
