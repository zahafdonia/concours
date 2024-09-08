package com.example.ddd.controller;

import com.example.ddd.model.Compte;
import com.example.ddd.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }
    @PostMapping("/createAccount")
    public Compte createAccount(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }
}
