package com.iskul.controllers;

import com.iskul.forms.RegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


@Component("registrationValidator")
public class RegistrationValidation {
	public boolean supports(Class<?> klass) {
		return RegistrationForm.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		RegistrationForm registrationForm = (RegistrationForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registrationForm.userName",
				"User Name must not be Empty.");
		String userName = registrationForm.getUserName();
		if ((userName.length()) > 50) {
			errors.rejectValue("userName",
					"lengthOfUser.registrationForm.userName",
					"User Name must not more than 50 characters.");
		}
//		if (!(registrationForm.getPassword()).equals(registrationForm
//				.getConfirmPassword())) {
//			errors.rejectValue("password",
//					"matchingPassword.registrationForm.password",
//					"Password and Confirm Password Not match.");
//		}
	}
}
