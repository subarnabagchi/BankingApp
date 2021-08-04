package com.app.accounts.repo;

import com.app.accounts.model.AcctTransaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("transactionRepo")
public interface TransactionRepo extends JpaRepository<AcctTransaction, Long> {

    List<AcctTransaction> findByAccountNumber(String accountNumber, Pageable pageable);
}
