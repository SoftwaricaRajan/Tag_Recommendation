package model;

import java.sql.Date;

public class User {
	/**
  CREATE TABLE `springdb`.`user` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
  INSERT INTO `springdb`.`user` (`id`, `username`, `password`, `first_name`, `last_name`, `birth_date`, `email`, 'gender') VALUES ('1', 'admin', 'admin', 'rajan', 'Papa', '2017-07-08', 'rajan@gmail.com', 'MALE');
	 */
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String username;
	private String password;
	private String gender;
	
	//reenter email:
	private String reenteremail;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", gender=" + gender + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReenteremail() {
		return reenteremail;
	}

	public void setReenteremail(String reenteremail) {
		this.reenteremail = reenteremail;
	}
	
	
}
