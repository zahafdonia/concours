package com.example.ddd.service;

import com.example.ddd.model.User;
import com.example.ddd.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ddd.repository.CompteRepository;
import com.example.ddd.model.Compte;
@Service
public class UserService {

    @Autowired
    private CompteRepository compteRepository; // Remplacez UserRepo par CompteRepository si nécessaire
    @Autowired
    private UserRepo userRepo;

    public void createUser(Long cin, String password) {
        User user = new User();
        user.setCin(cin);
        user.setPassword(password);

        userRepo.save(user);
    }
    public Compte getUserByCin(Long cin) {
        return compteRepository.findByCin(cin);
    }

}
