package com.example.timetacker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long task_id ;

    private  String name;

    private String description ;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority ;

    private LocalDateTime scheduledFrom ;

    private LocalDateTime scheduledTo ;

    private String user;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeEntry> timeEntries;


}
