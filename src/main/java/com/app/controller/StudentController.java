package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Student;
import com.app.service.IStudentService;
import com.app.util.StudentExcelExport;
import com.app.validate.StudentValidator;

@Controller
public class StudentController {

	@Autowired
	private IStudentService service;
	@Autowired
	private StudentValidator sValidator;
	// dispaly Stuent Reg Pages 

	@RequestMapping(value="/showStd")
	public String showStdReg(ModelMap map) {
		map.addAttribute("student", new Student());
		return "StudentRegistration";
	}
	//create Student Data
	@RequestMapping(value="/saveStd",method=RequestMethod.POST)
	public String saveStd(@ModelAttribute Student student,Errors errors,ModelMap map) {
		sValidator.validate(student, errors);
		if(errors.hasErrors()) {
			map.addAttribute("msg","Please Checks Errors..!");
		}else {
			int stdId=service.saveStd(student);
			map.addAttribute("msg", "Student Data Sucessfuly Inserted");
			map.addAttribute("student", new Student());
		}
		return "StudentRegistration";
	}

	/*
	//show One Student Data

	@RequestMapping(value="/viewStd")
	public String viewStd(@RequestParam Integer stdId,ModelMap map) {
		map.addAttribute("std", service.getStdById(stdId));
		return "StudentView";
	}
	// Get All Students Data 
	@RequestMapping("/AllStds")
	public String getAllStds(ModelMap map) {
		List<Student> stds=service.getAllStds();
		map.addAttribute("stds",stds);
		return "StudentData";
	}
	 */


	//	One Student Oject And All Student Objects
	@RequestMapping("/viewStd")
	public String viewStdDetails(@RequestParam(required=false,defaultValue="0")Integer stdId,ModelMap map) {
		String page=null;
		if(stdId!=0) {
			map.addAttribute("std", service.getStdById(stdId));
			page="StudentView";
		}else {
			map.addAttribute("stds",service.getAllStds());
			page="StudentData";
		}
		return page;
	}


	// show student update page
	@RequestMapping("/editStd")
	public String showEditstd(@RequestParam Integer stdId,ModelMap map) {
		Student std=service.getStdById(stdId);
		map.addAttribute("student",std);
		return "StudentEdit";
	}

	// update student data
	@RequestMapping(value="/updateStd",method=RequestMethod.POST)
	public String updateStd(@ModelAttribute Student student,ModelMap map) {
		service.updateStd(student);
		map.addAttribute("stds",service.getAllStds());
		return "StudentData";
	}
	// delete Studnet record
	@RequestMapping("/delete")
	public String deleteStd(@RequestParam int stdId) {
		service.deleteStd(stdId);
		return "redirect:AllStds";
	}

	// export data to excel view
	/* @RequestMapping(value="/exportExcel")
	public ModelAndView exportExcel() {
		List<Student> stds=service.getAllStds();
		return new ModelAndView(new StudentExcelExport(),"stds",stds);
	}
	@RequestMapping(value="/exportExcelOne")
	public ModelAndView ExportExcelOne(@RequestParam Integer stdId) {
			Student std=service.getStdById(stdId);
		return new ModelAndView(new StudentExcelExport(),"stds",Arrays.asList(std));
	}
	 */
	@RequestMapping(value="/srchStd") 
	public String srchPage() {
		return "StudentSearch";
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String findStd(@RequestParam String email,String  phNum,ModelMap map) {
		String page=null;
		Student stds=service.srchStd(email, phNum);
			if(stds==null) {
				map.addAttribute("msg", "Student Eamil or Phone number Invalid..!");
				return "StudentSearch";
			}else {
				map.addAttribute("std", stds);
				page="StudentView";
		
	return page;
	}
	}
	// exporting data to Excel view
	@RequestMapping(value="/exportEXcel")
	public ModelAndView exportDataToExcel(@RequestParam(required=false,defaultValue="0")Integer stdId) {
		if(stdId!=0) {
			Student std=service.getStdById(stdId);
			return new ModelAndView(new StudentExcelExport(),"stds",Arrays.asList(std));
		}
		else {
			List<Student> stds=service.getAllStds();
			return new ModelAndView(new StudentExcelExport(),"stds",stds);
		}
	}











}
