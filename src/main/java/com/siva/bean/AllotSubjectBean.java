package com.siva.bean;

public class AllotSubjectBean {

	String teachername;
	String day;
	int period;

	int classid;

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	String subject;
	String allotmenttype;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getDay() {
		return day.toString();
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAllotmenttype() {
		return allotmenttype;
	}

	public void setAllotmenttype(String allotmenttype) {
		this.allotmenttype = allotmenttype;
	}

}
