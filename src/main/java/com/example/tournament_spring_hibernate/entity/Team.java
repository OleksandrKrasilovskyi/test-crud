package com.example.tournament_spring_hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String teamName;

    @Column(name = "capitan_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String capitanName;

    @Column(name = "coach_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String coachName;

    //TODO learn about lazy and eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToMany(mappedBy = "teams")
    private List<Match> matches;
}
