package com.app.dao;

import java.util.List;

import com.app.model.Student;

public interface IStudentDao {

	public int saveStd(Student std);
	public void deleteStd(int stdId);
	public void updateStd(Student std);
	public Student getStdById(int stdId);
	public List<Student> getAllStds();
	public Student srchStd(String email,String phNum);
	public boolean checkEmailOrPhNum(String type, String EmailOrPhNum);
	public boolean isEmailOrPhNumExits(String type,String EmailOrPhNum);
}
