package com.example.ddd.repository;

import com.example.ddd.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByCin(Long cin);
    Compte getUserByCin(Long cin);
}
