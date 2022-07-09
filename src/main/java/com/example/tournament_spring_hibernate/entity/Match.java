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
@Table(name = "match")
public class Match implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @Column(length = 20)
    private String round;

    @Column(name = "first_team", length = 100)
    private String firstTeam;

    @Column(name = "second_team", length = 100)
    private String secondTeam;

    @Column
    private String score;

    //TODO learn about lazy and eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToMany
    @JoinTable(name = "match_teams",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", round='" + round + '\'' +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", score='" + score + '\'' +
                ", tournament=" + tournament +
                '}';
    }
}
