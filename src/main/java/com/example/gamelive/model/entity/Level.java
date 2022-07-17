package com.example.gamelive.model.entity;

import com.example.gamelive.model.entity.enums.TypeOfDuty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @Column(name = "level_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Long gettingCountBalls;

    @Column
    private Long fullCountBallsOfThisLevel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_task_id")
    private Task mainTask;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfDuty typeOfDuty;
}