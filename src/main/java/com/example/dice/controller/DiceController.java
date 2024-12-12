package com.example.dice.controller;

import com.example.dice.entities.Dice;
import com.example.dice.entities.DiceRollLog;
import com.example.dice.entities.DiceRollLogRepository;
import com.example.dice.entities.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {
    @Autowired
    private DiceService diceService;

    @Autowired
    private DiceRollLogRepository repository;

    /**
     * Endpoint pour lancer X dés.
     *
     * @param count Nombre de dés à lancer.
     * @return Liste des résultats des dés.
     */
    @GetMapping("/rollDices/{count}")
    public List<Integer> rollDices(@PathVariable int count) {
        return diceService.rollDices(count);
    }
    @GetMapping("/rollDice")
    public List<Integer> rollDices() {
        return diceService.rollDices(1);
    }

    /**
     * Endpoint pour récupérer l'historique des lancés.
     *
     * @return Liste des logs enregistrés dans la base.
     */
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return repository.findAll();
    }
}
