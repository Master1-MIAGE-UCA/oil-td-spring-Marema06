package com.example.dice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiceRollLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int diceCount;
    @ElementCollection
    private List<String> results = new ArrayList<>();
    private LocalDateTime timestamp;

    public void setDiceCount(int diceCount) {
    }

    public void setResults(List<Integer> results) {
    }

    public void setTimestamp(LocalDateTime now) {
    }
}

