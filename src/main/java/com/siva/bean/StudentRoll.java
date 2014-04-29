package com.siva.bean;

import java.util.List;

public class StudentRoll {
	String rollno;
	List<Subjects> s;

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public List<Subjects> getS() {
		return s;
	}

	public void setS(List<Subjects> s) {
		this.s = s;
	}

}