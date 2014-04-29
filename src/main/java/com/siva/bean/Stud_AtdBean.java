package com.siva.bean;

public class Stud_AtdBean {

	String roll;
	String[] rollno;

	public String[] getRollno() {
		return rollno;
	}

	public void setRollno(String[] rollno) {
		this.rollno = rollno;
	}

	String subjectname;
	int subjectid;
	int abscentclasses;

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public int getAbscentclasses() {
		return abscentclasses;
	}

	public void setAbscentclasses(int abscentclasses) {
		this.abscentclasses = abscentclasses;
	}

}
