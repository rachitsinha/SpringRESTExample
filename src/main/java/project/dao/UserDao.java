package project.dao;

import java.util.List;

import project.model.User;

public interface UserDao {
	
	User getUserById(String id);
	
	List<User> getAllUsers();

	List<User> searchUser(String searchInput);

	String addUser(User user);

	String deleteUserById(String id);

	String updateUserById(String id, User user);
}
