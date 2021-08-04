package com.app.accounts.repo;

import com.app.accounts.model.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("accountRepo")
public interface AccountRepo extends JpaRepository<Account, Long> {

    List<Account> findByCustomerId(String customerId, Pageable pageable);

}
