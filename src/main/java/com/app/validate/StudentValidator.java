package com.app.validate;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Student;
import com.app.service.IStudentService;
@Component
public class StudentValidator implements Validator{
	@Autowired
	private IStudentService service;
	@Override
	public boolean supports(Class<?> claz) {
		return Student.class.equals(claz);
	}

	@Override
	public void validate(Object target, Errors errors) {
			Student s=(Student) target;
			
			if(!Pattern.compile("[a-zA-Z]{5,20}").matcher(s.getStdName().trim()).matches()) {
					errors.rejectValue("stdName", null,"Please Enter Student Name");
			}
			
			if(!StringUtils.hasText(s.getStdPhNum().trim())) {
				errors.rejectValue("stdPhNum",null,"Please enter Ph Numer");
			}
			else if(!Pattern.matches("[6-9]{1}[\\d]{9}",s.getStdPhNum())){
				errors.rejectValue("stdPhNum", null, "Phone number Must Be 10 digites");
			}else if(service.isEmailOrPhNumExits("stdPhNum", s.getStdPhNum())) {
				errors.rejectValue("stdPhNum",null,"Phone Number All ready Exit");
			}else if(service.checkEmailOrPhNum("stdPhNum",s.getStdPhNum())) {
				errors.rejectValue("stdPhNum",null,"Invalid Phone Number ");
			}
			
			if(!StringUtils.hasText(s.getStdEmail().trim())) {
				errors.rejectValue("stdEmail", null, "Please Enter Email");
			}else if(!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",s.getStdEmail())) {
					errors.rejectValue("stdEmail",null,"Please Enter Valid Email address");
			}else if(service.isEmailOrPhNumExits("stdEmail", s.getStdEmail())) {
			errors.rejectValue("stdEmail",null,"Email Is all ready Exits");	
			}else if(service.checkEmailOrPhNum("stdEmail",s.getStdEmail())) {
				errors.rejectValue("stdEmail",null,"Invalid Email Address");
			}
			
			// radio
			if(s.getStdGen()==null || s.getStdGen().isEmpty()) {
					errors.rejectValue("stdGen",null, "Please select Gender");
			}
			
			//select box
			if(s.getStdBranch()==null ||"".equals(s.getStdBranch())) {
				errors.rejectValue("stdBranch",null,"please select at lease One branch");
			}
			
			//checkbox
			if(s.getStdCourse()==null ||s.getStdCourse().isEmpty()) {
				errors.rejectValue("stdCourse",null,"please select Course");
			}
	}

}
