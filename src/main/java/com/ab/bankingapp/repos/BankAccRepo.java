package com.ab.bankingapp.repos;

import com.ab.bankingapp.models.BankAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccRepo extends JpaRepository<BankAcc, Integer> {
}
