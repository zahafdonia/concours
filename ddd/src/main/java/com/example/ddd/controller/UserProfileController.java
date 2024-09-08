package com.example.ddd.controller;

import com.example.ddd.model.Compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ddd.service.UserService;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-details")
    public ResponseEntity<Compte> getUserProfile(@RequestParam Long cin) {
        Compte compte = userService.getUserByCin(cin);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
