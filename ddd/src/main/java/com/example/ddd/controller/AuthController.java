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
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

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
        // Trouver le compte associé au cin de l'utilisateur
        Compte compte = compteRepo.findByCin(user.getCin());
        return ResponseEntity.ok(compte); // Retourne l'objet Compte si la connexion est réussie
    }

    @GetMapping("/user-profile")
    public ResponseEntity<Compte> getUserProfile(@RequestParam Long cin) {
        Compte compte = compteRepo.findByCin(cin);
        if (compte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(compte); // Retourne les informations du compte
    }

    @PostMapping("auth/createAccount")
    public ResponseEntity<Compte> createAccount(@RequestBody Compte compte) {
        // Enregistrer d'abord le compte
        Compte savedCompte = compteRepo.save(compte);

        // Créer l'utilisateur associé
        User newUser = new User();
        newUser.setCin(savedCompte.getCin());
        newUser.setPassword(savedCompte.getPassword());
        userRepo.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompte);
    }
}
