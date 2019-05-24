package project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import project.mapper.UserMapper;
import project.model.User;

public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public User getUserById(String id) {
		String sql = "select * from USER where USER_ID = ? AND ACTIVE = 'Y'";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserMapper());
		return user;
	}

	public List<User> getAllUsers() {
		String sql = "select * from USER where ACTIVE = 'Y'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	public List<User> searchUser(String searchInput) {
		StringBuffer buff = new StringBuffer();
		
		buff.append("SELECT * FROM USER WHERE (FIRST_NAME LIKE '%").append(searchInput)
			.append("%' OR LAST_NAME LIKE '%").append(searchInput)
			.append("%' OR EMAIL LIKE '%").append(searchInput)
			.append("%' OR CONTACT LIKE '%").append(searchInput)
			.append("%') AND ACTIVE = 'Y'");
		
		List<User> users = jdbcTemplate.query(buff.toString(), new UserMapper());
		return users;
	}

	public String addUser(User user) {
		String sql = "insert into USER values(?,?,?,?,?, 'Y')";
		int rows = jdbcTemplate.update(sql, new Object[] { user.getUid(), user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPhoneNumber() });
		return (rows > 0) ? user.getUid() : null;
	}

	public String deleteUserById(String id) {
		String sql = "UPDATE USER SET ACTIVE= 'N' WHERE USER_ID=?";
		int rows = jdbcTemplate.update(sql, new Object[] { id });
		return (rows > 0) ? id : null;
	}

	public String updateUserById(String id, User user) {
		String sql = "UPDATE USER " + "SET " + "`FIRST_NAME` = ?, " + "`LAST_NAME` = ?, " + "`EMAIL` = ?, "
				+ "`CONTACT` = ? " + "WHERE " + "`USER_ID` = ? AND ACTIVE = 'Y'";
		int rows = jdbcTemplate.update(sql,
				new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), id });

		return (rows > 0) ? id : null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
