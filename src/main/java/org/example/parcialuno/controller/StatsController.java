package org.example.parcialuno.controller;

import org.example.parcialuno.dto.DtoStats;
import org.example.parcialuno.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping
    public DtoStats getStats() {
        return statsService.getStats();
    }
}
