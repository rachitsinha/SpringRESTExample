package project.dao;

import java.util.ArrayList;
import java.util.List;

import project.model.User;

public class UserDaoImpl implements UserDao {
	
	List<User> users;
	
	public UserDaoImpl() {
		this.users = new ArrayList<User>();
	}

	public User getUserById(String id) {
		for(User user: this.users) {
			if(user.getUid().equalsIgnoreCase(id)) {
				return user;
			}
		}
		return null;
	}

	public List<User> getAllUsers() {
		return this.users;
	}

	public List<User> searchUser(String searchInput) {
		List<User> results = new ArrayList<User>();
		for(User user: this.users) {
			if(user.getUid().toLowerCase().indexOf(searchInput.toLowerCase()) != -1 
				|| user.getFirstName().toLowerCase().indexOf(searchInput.toLowerCase()) != -1
				|| user.getLastName().toLowerCase().indexOf(searchInput.toLowerCase()) != -1
				|| user.getEmail().toLowerCase().indexOf(searchInput.toLowerCase()) != -1
				|| user.getPhoneNumber().indexOf(searchInput) != -1) {
				
				results.add(user);
			}
		}
		return results;
	}

	public String addUser(User user) {
		this.users.add(user);
		return user.getUid();
	}

	public String deleteUserById(String id) {
		int index = -1;
		for(int i=0; i < this.users.size(); i++) {
			if(this.users.get(i).getUid().equalsIgnoreCase(id)) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			User removed = this.users.remove(index);
			return removed.getUid();
		}
		
		return null;
	}

	public String updateUserById(String id, User userObj) {
		for(User user: this.users) {
			if(user.getUid().equalsIgnoreCase(id)) {
				user = userObj;
				user.setUid(id);
				return user.getUid();
			}
		}
		return null;
	}

}
