package project.service;

import java.util.List;

import project.dao.UserDao;
import project.dao.UserDaoImpl;
import project.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
	}

	public User getUserById(String id) {
		return this.userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}

	public List<User> searchUser(String searchInput) {
		return this.userDao.searchUser(searchInput);
	}

	public String addUser(User user) {
		return this.userDao.addUser(user);
	}

	public String deleteUserById(String id) {
		return this.userDao.deleteUserById(id);
	}

	public String updateUserById(String id, User user) {
		return this.userDao.updateUserById(id, user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
