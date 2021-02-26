package com.bank.account.jpa.BankAccountJPA;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GetDataService extends JpaRepository<AccountUser,Integer>{

	
	@Override
	ArrayList<AccountUser> findAll();
	

	
	
}
