package project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.model.User;

public class UserMapper implements RowMapper<User> {

	public UserMapper() {
		// TODO Auto-generated constructor stub
	}

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUid(rs.getString("USER_ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setEmail(rs.getString("EMAIL"));
		user.setPhoneNumber(rs.getString("CONTACT"));
		return user;
	}

}
