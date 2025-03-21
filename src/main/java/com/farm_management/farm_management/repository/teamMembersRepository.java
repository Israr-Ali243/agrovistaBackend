package com.farm_management.farm_management.repository;

import com.farm_management.farm_management.entity.TeamMember;
import com.farm_management.farm_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface teamMembersRepository extends JpaRepository<TeamMember, Long> {

    @Query("SELECT tm FROM TeamMember tm WHERE tm.team.id = :teamId AND tm.user.Id = :userId")
    Optional<TeamMember> findByTeamIdAndUserId(@Param("teamId") Long teamId, @Param("userId") Long userId);

    @Query("SELECT tm.user FROM TeamMember tm WHERE tm.team.id = :teamId")
    List<User> findUsersByTeamId(@Param("teamId") Long teamId);
}
