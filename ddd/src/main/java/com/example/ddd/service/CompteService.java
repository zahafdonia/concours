package com.example.ddd.service;

import com.example.ddd.model.Compte;
import com.example.ddd.model.User;
import com.example.ddd.repository.CompteRepository;
import com.example.ddd.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private UserRepo userRepo;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Compte saveCompte(Compte compte) {
        // Enregistrer le compte
        Compte savedCompte = compteRepository.save(compte);

        // Créer et enregistrer l'utilisateur associé
        User newUser = new User();
        newUser.setCin(savedCompte.getCin());
        newUser.setPassword(savedCompte.getPassword());
        userRepo.save(newUser);

        return savedCompte;
    }
}
