package project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import project.model.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	List<User> users;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<User> getAllUsers() {
		return users;
	}

	public List<User> searchUser(String searchInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateUserById(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
