package com.siva.service;

import java.util.Map;
import java.util.TreeMap;

public class ClassMapper {
	
	Map<Integer,String>  tm;
	String section;
	public  String mapper(int a)
	{
		tm=new TreeMap<Integer,String>();
		
		tm.put(1,"CSE-1-1");
		tm.put(2,"CSE-1-2");
		tm.put(3,"CSE-2-1");
		tm.put(4,"CSE-2-2");
		tm.put(5,"CSE-3-1");
		tm.put(6,"CSE-3-2");
		tm.put(7,"CSE-4-1");
		tm.put(8,"CSE-4-2");
		
		
		tm.put(9,"ECE-1-1");
		tm.put(10,"ECE-1-2");
		tm.put(11,"ECE-2-1");
		tm.put(12,"ECE-2-2");
		tm.put(13,"ECE-3-1");
		tm.put(14,"ECE-3-2");
		tm.put(15,"ECE-4-1");
		tm.put(16,"ECE-4-2");
		
		
		tm.put(17,"EEE-1-1");
		tm.put(18,"EEE-1-2");
		tm.put(19,"EEE-2-1");
		tm.put(20,"EEE-2-2");
		tm.put(21,"EEE-3-1");
		tm.put(22,"EEE-3-2");
		tm.put(23,"EEE-4-1");
		tm.put(24,"EEE-4-2");
		
		
		
		tm.put(25,"IT-1-1");
		tm.put(26,"IT-1-2");
		tm.put(27,"IT-2-1");
		tm.put(28,"IT-2-2");
		tm.put(29,"IT-3-1");
		tm.put(30,"IT-3-2");
		tm.put(31,"IT-4-1");
		tm.put(32,"IT-4-2");
		return tm.get(a);
			
	}
}
