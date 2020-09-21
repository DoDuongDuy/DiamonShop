package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.Users;

@Service
public interface IAccountService {
	public int AddAcount(Users user);
	public Users CheckAccount(Users user);
	
}
