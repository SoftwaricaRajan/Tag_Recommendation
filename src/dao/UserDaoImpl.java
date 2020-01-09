package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDaoImpl extends DB implements UserDao{

	@Override
	public boolean validateUser(String username, String password) {
		
		try {
			Connection conn = getDBConnection();
			Statement stat = conn.createStatement();
			//select * from user where username='admin' and password='admin123';
			String sql = 
					"select * from user where email='" + username + 
					"' and password='" + password + "'";
			System.out.println(sql);
			ResultSet rs = stat.executeQuery(sql);
			return rs.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void saveUser(User user) {
		user.setBirthDate(new Date(2018,06,15));
		try {
			Connection conn = getDBConnection();
			//INSERT INTO `springdb`.`user` (`id`, `username`, `password`, `first_name`, `last_name`, `birth_date`, `email`, `gender`) VALUES ('1', 'admin', 'admin', 'John', 'Papa', '2018-07-08', 'john@gmail.com', 'MALE');
			String sql =  "INSERT INTO `user` (`username`, `password`, `first_name`, `last_name`, `birth_date`, `email`, `gender`) VALUES (?,?,?,?,?,?,?)";
			System.out.println(sql);
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getFirstName());
			stat.setString(4, user.getLastName());
			stat.setDate(5, user.getBirthDate());
			stat.setString(6, user.getEmail());
			stat.setString(7,  user.getGender());
			
			stat.executeUpdate();
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findUserByUsernameOrEmail(String username) {
		try {
			Connection conn = getDBConnection();
			Statement stat = conn.createStatement();
			//select * from user where username='admin' and password='admin123';
			String sql = 
					"select email from user where username='" + username + 
					"' OR email='" + username + "'";
			System.out.println(sql);
			ResultSet rs = stat.executeQuery(sql);
			return rs.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
