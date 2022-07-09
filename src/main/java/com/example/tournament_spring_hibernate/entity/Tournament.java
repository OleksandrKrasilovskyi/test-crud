package com.example.tournament_spring_hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "tournament")
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Long id;

    @Column(name = "tournament_name", nullable = false, length = 100)
    private String tournamentName;

    @OneToMany(mappedBy = "tournament")
    private Set<Team> teams;

    @OneToMany(mappedBy = "tournament")
    private Set<Match> matches;

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournamentName='" + tournamentName + '\'' +
                '}';
    }
}