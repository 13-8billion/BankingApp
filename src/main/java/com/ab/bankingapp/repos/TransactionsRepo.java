package com.ab.bankingapp.repos;

import com.ab.bankingapp.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

}
