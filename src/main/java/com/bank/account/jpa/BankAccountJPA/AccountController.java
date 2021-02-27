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
		System.out.println(user.getID());
		if(user.getID() != null)
		{
			userUpdate = fetchDataService.findById(user.getID());
			if(userUpdate.isPresent())
			{
				System.out.print("get in here");
				if(user.getAccNum() == null) {
					user.setAccNum(userUpdate.get().getAccNum());
				}
				if(user.getfName() ==null)
				{
					user.setfName(userUpdate.get().getfName());
				}
				if(user.getlName() ==null)
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
				if(user.getPhoneNumber() ==0 )
				{
						user.setPhoneNumber(userUpdate.get().getPhoneNumber());
				}
			
				
				
			}

			fetchDataService.save(user);
			
		}	
		
	}
	
	private AccountUser getUser(int Id)
	{
		
		Optional<AccountUser> userUpdate = null;

		AccountUser user = null;
			userUpdate = fetchDataService.findById(Id);
			if(userUpdate.isPresent())
			{
				user = new AccountUser();
					user.setID(userUpdate.get().getID());
					user.setAccNum(userUpdate.get().getAccNum());
					user.setfName(userUpdate.get().getfName());

					user.setlName(userUpdate.get().getlName());

					user.setBalance(userUpdate.get().getBalance());
		
					user.setEmail(userUpdate.get().getEmail());
		
					user.setBalance(userUpdate.get().getBalance());
					user.setPhoneNumber(userUpdate.get().getPhoneNumber());
				
			}

			return user;	
	}	
		
		
	
	@GetMapping("/FindUser/{AccNum}")
	public Optional<AccountUser> findUser (@PathVariable("AccNum") int AccNum)
	{
		return fetchDataService.findById(AccNum);
	}
	
	@DeleteMapping("/DeleteUser/{AccNum}")
	public void deleteUser (@PathVariable("AccNum") int AccNum)
	{
		if(fetchDataService.existsById(AccNum))
		{
			fetchDataService.deleteById(AccNum);
		}
	
	}
	
	@PostMapping("/Withdraw/{id}/{Amount}")
	public void withdraw(@PathVariable("id") int id, @PathVariable ("Amount") double Amount)
	{
			AccountUser user = getUser(id);
			double tempValue;
			if(user != null)
			{
				tempValue = user.getBalance() - Amount;
				if(tempValue > 0)
				{
					user.setBalance(tempValue);;
				}
				fetchDataService.save(user);
			}
	}
	@PostMapping("/Deposit/{id}/{Amount}")
	public void deposit(@PathVariable("id") int id, @PathVariable ("Amount") double Amount)
	{
			AccountUser user = getUser(id);

			user.setBalance(user.getBalance()+Amount);
			
			fetchDataService.save(user);
		
	}
}
