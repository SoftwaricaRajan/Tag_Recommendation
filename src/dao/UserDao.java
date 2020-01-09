package dao;

import model.User;

public interface UserDao {
	boolean validateUser(String username, String password);
	void saveUser(User user);
	boolean findUserByUsernameOrEmail(String username);
}
