package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.entity.Team;
import com.farm_management.farm_management.entity.TeamMember;
import com.farm_management.farm_management.entity.User;
import com.farm_management.farm_management.service.emailService;
import com.farm_management.farm_management.service.teamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm_management.farm_management.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class teamMemberServiceImpl implements teamMemberService {
    @Autowired
    private teamMembersRepository teamMembersRepository;
    @Autowired
    private teamRepository teamRepository;
    @Autowired
    private userRepository userRepository;

    @Autowired
    private emailService emailService;

    @Override
    public TeamMember addMemberToTeam(int teamId, int userId, String role) {

        Optional<User> user = userRepository.findById(Long.valueOf(userId));
        Optional<Team> team = teamRepository.findById(Long.valueOf(teamId));
        if (user.isPresent() && team.isPresent()){
            TeamMember teamMember = new TeamMember();
            teamMember.setRole(role);

            Team team1 = team.get();
            User user1 = user.get();
            teamMember.setUser(user1);
            teamMember.setTeam(team1);
            teamMember.setJoinedAt(new Date());
            emailService.sendEmail(user1.getEmail(), "Your Have Been Add in a Team", "Hello "+user1.getUsername()+" you are Added in a Team "+ team1.getName());
           return teamMembersRepository.save(teamMember);
        }
        return null;
    }

    @Override
    public void removeMemberFromTeam(int teamId, int userId) {

      Optional<TeamMember> teamMember=  teamMembersRepository.findByTeamIdAndUserId(Long.valueOf(teamId), Long.valueOf(userId));
        if (teamMember.isPresent()){
            TeamMember teamMember1 = teamMember.get();
            teamMembersRepository.deleteById(Long.valueOf(teamMember1.getId()));
        }

    }

    @Override
    public List<User> getAllMembersOfTeam(int teamId) {
        return teamMembersRepository.findUsersByTeamId(Long.valueOf(teamId));
    }

    @Override
    public boolean isUserPartOfTeam(int teamId, int userId) {
        Optional<TeamMember> teamMember= teamMembersRepository.findByTeamIdAndUserId(Long.valueOf(teamId), Long.valueOf(userId));
        return teamMember.isPresent();
    }
}
