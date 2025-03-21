package com.farm_management.farm_management.controller;

import com.farm_management.farm_management.entity.Team;
import com.farm_management.farm_management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farm_management.farm_management.service.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class teamController {
    @Autowired
    private teamService teamService;
    @Autowired
    private emailService emailService;

    @PostMapping("/save")
    public ResponseEntity<Team>  createTeam(@RequestBody Team team){
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody  Team team){
        return ResponseEntity.ok(teamService.updateTeam(team));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") int id){
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") int id){
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Team>> getAll(){
        return ResponseEntity.ok(teamService.getAll());
    }

    @GetMapping("/findAll/user/{id}")
    public ResponseEntity<List<User>> getAllUserOfTeam(@PathVariable("id") int id ){
        return ResponseEntity.ok(teamService.getAllUserOfTeam(id));
    }



}
