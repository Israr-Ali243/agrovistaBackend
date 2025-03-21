package com.farm_management.farm_management.service;

import com.farm_management.farm_management.entity.TeamMember;
import com.farm_management.farm_management.entity.User;

import java.util.List;

public interface teamMemberService {

    TeamMember addMemberToTeam(int teamId, int userId, String role);
    void removeMemberFromTeam(int teamId, int userId);
    List<User> getAllMembersOfTeam(int teamId);
    boolean isUserPartOfTeam(int teamId, int userId);
}
