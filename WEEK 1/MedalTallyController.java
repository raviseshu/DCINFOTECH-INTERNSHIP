package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MedalTallyService;

import java.util.List;

@RestController
public class MedalTallyController {

    @Autowired
    private MedalTallyService csvService;

    @GetMapping("/process-csv")
    public List<String[]> processCSV() {
        return csvService.readCSV();
    }
    
    
}