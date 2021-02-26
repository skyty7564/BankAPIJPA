package com.bank.account.jpa.BankAccountJPA;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	

	@GetMapping("/GetUser")
	public ArrayList<AccountUser> getAllUser()
	{
	
		
		return fetchDataService.findAll();
		 
	}
	@PutMapping("/SaveUser")
	public void saveUser (@RequestBody AccountUser user)
	{
		fetchDataService.save(user);
	}
	@PostMapping("/UpdateUser")
	public void updateUser(@RequestBody AccountUser user)
	{
		Optional<AccountUser> userUpdate = null;

		if(user.getAccNum() != null)
		{
			userUpdate = fetchDataService.findById(user.getAccNum());
			
		}	
		if(userUpdate.isPresent())
		{
			if(user.getfName() == null)
			{
				user.setfName(userUpdate.get().getfName());
			}
			if(user.getlName() == null)
			{
				user.setlName(userUpdate.get().getlName());
			}
			if(user.getBalance() == 0)
			{
				user.setBalance(userUpdate.get().getBalance());
			}
			if(user.getEmail() == null)
			{
				user.setEmail(userUpdate.get().getEmail());
			}
			if(user.getPhoneNumber() == 0)
			{
				user.setPhoneNumber(userUpdate.get().getPhoneNumber());
			}
			fetchDataService.save(user);
		}

		
	
		
		
	}
	
	@GetMapping("/FindUser/{AccNum}")
	public Optional<AccountUser> findUser (@PathVariable("AccNum") int AccNum)
	{
		return fetchDataService.findById(AccNum);
	}
	
	@PostMapping("/DeleteUser/{AccNum}")
	public void deleteUser  (@PathVariable("AccNum") int AccNum)
	{
		fetchDataService.deleteById(AccNum);
	}
	
}
