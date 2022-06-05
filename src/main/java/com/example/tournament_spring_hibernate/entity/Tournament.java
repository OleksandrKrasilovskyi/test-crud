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
@Table(name = "tournament")
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Long id;

    @Column(name = "tournament_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String tournamentName;

    @OneToMany(mappedBy = "tournament")
    private List<Team> teams;

    @OneToMany(mappedBy = "tournament")
    private List<Match> matches;

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournamentName='" + tournamentName + '\'' +
                '}';
    }
}