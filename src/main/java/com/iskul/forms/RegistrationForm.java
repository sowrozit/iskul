package com.iskul.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegistrationForm {

	private String userName;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String password;

	@NotEmpty
	private String phoneNumber;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String userType;

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getUserType()
    {
        return userType;
    }
    public void setUserType(String userType)
    {
        this.userType=userType;
    }

}