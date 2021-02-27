package com.bank.account.jpa.BankAccountJPA;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BankUserDao {
	@Autowired
	GetDataService fetchDataService;
	
	public ArrayList<AccountUser>displayAllUser()
	{
		return fetchDataService.findAll();
	}
	
	
	public void saveUser(AccountUser user)
	{
		fetchDataService.save(user);
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
	public void updateUser(AccountUser user)

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
	public void withdraw(int id, double Amount)
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
	public void deposit(int id, double Amount)
	{
		AccountUser user = getUser(id);

		user.setBalance(user.getBalance()+Amount);
		
		fetchDataService.save(user);
	}
	public void deleteUser(int AccNum)
	{
		if(fetchDataService.existsById(AccNum))
		{
			fetchDataService.deleteById(AccNum);
		}
	}
	
	public Optional<AccountUser> findUser(int AccNum)
	{
		
		return fetchDataService.findById(AccNum);
		
	}
}


