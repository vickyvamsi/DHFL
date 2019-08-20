package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vam_tab")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stdId;
	private String stdName;
	private String stdEmail;
	private String stdPhNum;
	private String stdGen;
	private String stdBranch;
	private String stdCourse;
	private String stdAddr;
	public Student() {
		super();
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getStdPhNum() {
		return stdPhNum;
	}
	public void setStdPhNum(String stdPhNum) {
		this.stdPhNum = stdPhNum;
	}
	public String getStdGen() {
		return stdGen;
	}
	public void setStdGen(String stdGen) {
		this.stdGen = stdGen;
	}
	public String getStdBranch() {
		return stdBranch;
	}
	public void setStdBranch(String stdBranch) {
		this.stdBranch = stdBranch;
	}
	public String getStdCourse() {
		return stdCourse;
	}
	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}
	public String getStdAddr() {
		return stdAddr;
	}
	public void setStdAddr(String stdAddr) {
		this.stdAddr = stdAddr;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdEmail=" + stdEmail + ", stdPhNum=" + stdPhNum
				+ ", stdGen=" + stdGen + ", stdBranch=" + stdBranch + ", stdCourse=" + stdCourse + ", stdAddr="
				+ stdAddr + "]";
	}
	
	
	
}
