package com.farm_management.farm_management.service;

import com.farm_management.farm_management.entity.Team;
import com.farm_management.farm_management.entity.User;

import java.util.List;

public interface teamService {
    Team createTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeam(int id);
    Team getTeamById(int id);
    List<Team> getAll();
    List<User> getAllUserOfTeam(int id);

}
