package com.lti.training.user;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserManager {

	private List<User> users;
	
	public InMemoryUserManager() {
		users = new ArrayList<User>();
		users.add(new User("majrul", "123", 1));
		users.add(new User("dinesh", "456", 0));
		users.add(new User("gaurav", "789", 0));
	}
	
	public int isValidUser(String username, String password) {
		for(User user : users)
			if(user.getUsername().equals(username))
				if(user.getPassword().equals(password))
					if(user.isActive())
						return true;
			return false;
	}

	
	
}
*/