package com.farm_management.farm_management.controller;

import com.farm_management.farm_management.entity.TeamMember;
import com.farm_management.farm_management.entity.User;
import com.farm_management.farm_management.utils.TaskCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farm_management.farm_management.service.*;

import java.util.List;

@RestController
@RequestMapping("/team/member")
public class teamMemberController {
    @Autowired
    private teamMemberService teamMemberService;


    @PostMapping("/save/team_id/{team_id}/user_id/{user_id}/role/{role}")
    public ResponseEntity<TeamMember> addMemberToTeam(@PathVariable("team_id") int team_id,
                                                      @PathVariable("user_id") int user_id,
                                                      @PathVariable("role") String role){
        return ResponseEntity.ok(teamMemberService.addMemberToTeam(team_id, user_id, role));
    }

    @DeleteMapping("delete/team/member/team_id/{team_id}/user_id/{user_id}")
    public ResponseEntity<?> removeMemberFromTeam(@PathVariable("team_id") int team_id,
                                                  @PathVariable("user_id") int user_id){
       teamMemberService.removeMemberFromTeam(team_id, user_id);
       return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping("/getAll/team/member/team_id/{team_id}")
    public ResponseEntity<List<User>> getAllMembersOfTeam(@PathVariable("team_id") int team_id){
        return ResponseEntity.ok(teamMemberService.getAllMembersOfTeam(team_id));
    }

    @GetMapping("/check/team/member/team_id/{team_id}/user_id/{user_id}")
    public ResponseEntity<Boolean> isUserPartOfTeam(@PathVariable("team_id") int team_id,
                                                    @PathVariable("user_id") int user_id){
        return ResponseEntity.ok(teamMemberService.isUserPartOfTeam(team_id, user_id));
    }


}
