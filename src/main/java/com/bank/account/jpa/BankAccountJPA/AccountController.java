package com.bank.account.jpa.BankAccountJPA;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	

	
	@GetMapping ("/Test")
	public int Hello()
	{
		int list = 1;
		return list;
	}
	
	
	@Autowired
	GetDataService fetchDataService;
	
	@Autowired
	BankUserDao listUser = new BankUserDao();
	

	@GetMapping("/GetUser")
	public ArrayList<AccountUser> getAllUser()
	{
	
		return listUser.displayAllUser();
		 
	}
	@PutMapping("/SaveUser")
	public void saveUser (@RequestBody AccountUser user)
	{
		listUser.saveUser(user);
	}
	@PostMapping("/UpdateUser")
	public void updateUser(@RequestBody AccountUser user)
	{
		listUser.updateUser(user);
		
	}
	
	
		
		
	
	@GetMapping("/FindUser/{AccNum}")
	public Optional<AccountUser> findUser (@PathVariable("AccNum") int AccNum)
	{
		return listUser.findUser(AccNum);
	}
	
	@DeleteMapping("/DeleteUser/{AccNum}")
	public void deleteUser (@PathVariable("AccNum") int AccNum)
	{
		listUser.deleteUser(AccNum);
	
	}
	
	@PostMapping("/Withdraw/{id}/{Amount}")
	public void withdraw(@PathVariable("id") int id, @PathVariable ("Amount") double Amount)
	{
		listUser.withdraw(id, Amount);
	}
	@PostMapping("/Deposit/{id}/{Amount}")
	public void deposit(@PathVariable("id") int id, @PathVariable ("Amount") double Amount)
	{
		listUser.deposit(id, Amount);
		
	}
}
