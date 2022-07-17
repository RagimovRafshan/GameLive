package com.example.gamelive.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @Column(name = "task_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String descriptionTask;

    @Column
    @Basic
    private Date startPoint;

    @Column
    private Boolean isPerformed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Long moneyCapital;

    @Basic
    @Column(nullable = true)
    private Timestamp leadTime; /** <-- Время выполнения */
}