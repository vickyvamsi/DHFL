package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.model.Student;
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;
	@Transactional
	public int saveStd(Student std) {
		return dao.saveStd(std);
	}

	@Transactional
	public void deleteStd(int stdId) {
		dao.deleteStd(stdId);
	}

	@Transactional
	public void updateStd(Student std) {
				dao.updateStd(std);
	}

	@Transactional(readOnly=true)
	public Student getStdById(int stdId) {
		return dao.getStdById(stdId);
	}

	@Transactional(readOnly=true)
	public List<Student> getAllStds() {
		return dao.getAllStds()
				;
	}

	@Transactional(readOnly=true)
	public boolean isEmailOrPhNumExits(String type, String EmailOrPhNum) {
		return dao.isEmailOrPhNumExits(type, EmailOrPhNum);
	}

	@Transactional(readOnly=true)
	public Student srchStd(String email, String phNum) {
		return dao.srchStd(email, phNum);
	}

	@Override
	public boolean checkEmailOrPhNum(String type, String EmailOrPhNum) {
		return dao.checkEmailOrPhNum(type, EmailOrPhNum);
				
	}

	
}
