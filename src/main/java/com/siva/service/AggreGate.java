package com.siva.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.siva.bean.Subjects;

public class AggreGate {
		
	public Map<String,Double> individualAtten(Map<String,List<Subjects>> m)
	{
		System.out.println("here the size of the students map is"+m.size());
		 Map<String,Double> attendance=new TreeMap<String,Double>();
		Set<String> s=m.keySet();
		//System.out.println("the students size is "+s.size());
		Iterator<String> itr=s.iterator();
		while(itr.hasNext())
		{
			String roll=(String) itr.next();
			List<Subjects> a=m.get(roll);
			System.out.println("here in aggreateservice  the subjects size is "+a.size());
			Iterator<Subjects> itre=a.iterator();
			double totalclasses=0;
			int attendendclasses=0;
			double attendancepercentage=0;
			while(itre.hasNext())
			{
				Subjects t=(Subjects)itre.next();
				
				totalclasses=totalclasses+t.getTotalclasses();
				
				attendendclasses=attendendclasses+t.getAttendentlasses();
				
			}
			//System.out.println("--------------"+totalclasses);
			//System.out.println("--------------------"+attendendclasses);
			try
			{
			 attendancepercentage=(attendendclasses*100/totalclasses);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			 
			 // System.out.println("attendance perecntageis---- "+Math.ceil(attendancepercentage));
			  attendance.put(roll,Math.ceil(attendancepercentage));
				
		}
		return attendance;
		} 
	
	public Map<String,Double> subjectWiseAttd(Map<String,Subjects> m)
	{
		double attendancepercentage=0;
		Map<String,Double> sat=new TreeMap<String,Double>();
		Set<String> s=m.keySet();
		Iterator<String> itr=s.iterator();
		while(itr.hasNext())
		{
			String roll=(String) itr.next();
			Subjects a=m.get(roll);
			double at=a.getAttendentlasses();
			double tt=a.getTotalclasses();
			attendancepercentage=at*100/tt;
			sat.put(roll, attendancepercentage);
			
		}
		return sat;
	}
		}


