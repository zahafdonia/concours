package com.example.ddd.controller;

import com.example.ddd.model.Compte;
import com.example.ddd.model.User;
import com.example.ddd.repository.CompteRepository;
import com.example.ddd.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CompteRepository compteRepo;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        User user = userRepo.findByCin(userData.getCin());
        if (user == null || !user.getPassword().equals(userData.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        Compte compte = compteRepo.findByCin(user.getCin());
        return ResponseEntity.ok(compte); // Retourne le compte si la connexion est réussie
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@RequestParam Long cin) {
        Compte compte = compteRepo.findByCin(cin);
        if (compte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok(compte);
    }
}
