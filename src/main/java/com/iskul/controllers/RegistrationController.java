package com.iskul.controllers;


import com.iskul.forms.RegistrationForm;
import com.iskul.model.User;
import com.iskul.model.Registration;
import com.iskul.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("registration")
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	private RegistrationValidation registrationValidation;



	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	@RequestMapping(value = "/registrationsuccess")
	public ModelAndView listUser(ModelAndView model, HttpServletRequest request) throws IOException {
		User u = (User) request.getSession().getAttribute("usr");
		System.out.println(u.getUserName());
		model.addObject("username",u.getUserName());
		model.setViewName("registrationsuccess");
		return model;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		RegistrationForm registrationForm = new RegistrationForm();
		model.put("registrationForm", registrationForm);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid RegistrationForm registrationForm,
			BindingResult result) {
		// set custom Validation by user
//		registrationValidation.validate(registrationForm, result);
		if (result.hasErrors()) {
			return "registrationform";
		}
		Registration registration = new Registration();
		registration.setEmail(registrationForm.getEmail());
		registration.setUserName(registrationForm.getUserName());
		registration.setPassword(registrationForm.getPassword());
		registration.setPhoneNumber(registrationForm.getPhoneNumber());
		registration.setUserType(registrationForm.getUserType());
		registrationService.saveRegistration(registration);
		return "registrationsuccess";
	}
}
