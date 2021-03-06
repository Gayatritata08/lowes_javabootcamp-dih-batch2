package com.lowes.bankingapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lowes.bankingapp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
