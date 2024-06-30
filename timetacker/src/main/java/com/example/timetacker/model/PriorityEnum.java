package com.example.timetacker.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PriorityEnum {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String displayName;
}

