package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.entity.Team;
import com.farm_management.farm_management.entity.User;
import com.farm_management.farm_management.service.teamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.farm_management.farm_management.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class teamServiceImpl implements teamService {

    @Autowired
    private teamRepository teamRepository;
    @Override
    public Team createTeam(Team team) {
        team.setCreated_at(new Date());
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        Optional<Team> teambyId = teamRepository.findById((long) team.getId());
        if (teambyId.isPresent()){
            Team updatedTeam = teambyId.get();
            updatedTeam.setId(team.getId());
            updatedTeam.setName(team.getName());
            updatedTeam.setUpdated_at(new Date());
          return  teamRepository.save(updatedTeam);
        }
        return null;
    }

    @Override
    public void deleteTeam(int id) {
       teamRepository.deleteById((long) id);
    }

    @Override
    public Team getTeamById(int id) {
        Optional<Team> teamById = teamRepository.findById(Long.valueOf(id));
        return teamById.orElse(null);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public List<User> getAllUserOfTeam(int id) {
        return teamRepository.findUsersByTeamId((long)id);
    }
}
