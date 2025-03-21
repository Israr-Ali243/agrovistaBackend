package com.farm_management.farm_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;
    @Column(name = "team_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
    private Date created_at;
    private Date updated_at;

}
