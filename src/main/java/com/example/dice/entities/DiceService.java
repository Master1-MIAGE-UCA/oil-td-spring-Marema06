package com.example.dice.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {
    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    /**
     * Lancer un seul dé.
     */
    public int rollSingleDice() {
        int result = dice.roll();
        saveLog(1, List.of(result)); // Enregistrer le résultat
        return result;
    }

    /**
     * Lancer X dés, enregistrer les résultats et retourner les résultats.
     *
     * @param diceCount Nombre de dés à lancer.
     * @return Liste des résultats des lancés.
     */
    public List<Integer> rollDices(int diceCount) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll());
        }

        // Enregistrer l'historique dans la base
        saveLog(diceCount, results);

        return results;
    }

    /**
     * Enregistrer un historique de lancer de dés dans la base.
     *
     * @param diceCount Nombre de dés lancés.
     * @param results   Résultats des dés.
     */
    private void saveLog(int diceCount, List<Integer> results) {
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);
    }
}
