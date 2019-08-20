package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IStudentDao;
import com.app.model.Student;
@Repository
public class StudentDaoImpl implements IStudentDao {

		@Autowired
		private HibernateTemplate ht;
		
	@Override
	public int saveStd(Student std) {
		return (int) ht.save(std);
	}

	public void deleteStd(int stdId) {
		Student s=new Student();
		s.setStdId(stdId);
		ht.delete(s);
	}

	@Override
	public void updateStd(Student std) {
			ht.update(std);
	}

	@Override
	public Student getStdById(int stdId) {
		return ht.get(Student.class, stdId);
	}

	@Override
	public List<Student> getAllStds() {
		return ht.loadAll(Student.class);
	}

	@Override
	public boolean isEmailOrPhNumExits(String type, String EmailOrPhNum) {
		Long count=(long) 0;
		String hql="select count("+type+") from " + Student.class.getName() +" where "+type+"=?";
		List<Long> stdUser=(List<Long>) ht.find(hql, EmailOrPhNum);
		if(stdUser!=null && !stdUser.isEmpty()) {
			count=stdUser.get(0);
		}
		return count>0?true:false;
	}

	public boolean checkEmailOrPhNum(String type, String EmailOrPhNum) {
		Long count=(long) 0;
		String hql="select count("+type+") from " + Student.class.getName() +" where "+type+"=?";
		List<Long> stdUser=(List<Long>) ht.find(hql, EmailOrPhNum);
		if(stdUser==null && stdUser.isEmpty()) {
			count=stdUser.get(0);
		}
		return count>0?true:false;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Student srchStd(String email, String phNum) {
		Student student=null;
		String hql="from " +Student.class.getName()+ " where stdEmail=? and stdPhNum=?";
		List<Student> stdList=(List<Student>) ht.find(hql, email,phNum);
		if(stdList!=null && !stdList.isEmpty()) {
			student=stdList.get(0);
		}
		return student;
	}

}
