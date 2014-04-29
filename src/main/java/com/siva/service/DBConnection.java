package com.siva.service;

import java.sql.*;
import java.io.*;
import java.util.*;



public class DBConnection {
	
	
	Connection	connection;
	
	public Connection getConnection() throws SQLException {
   try
{
   String url = "jdbc:postgresql://ec2-54-221-225-251.compute-1.amazonaws.com:5432/d6fabmqf6v966m";
Properties props = new Properties();
props.setProperty("user","jtibejunaovgzp");
props.setProperty("password","EncYd2AJld6k85Dt6hl1pViRfA");
props.setProperty("ssl","true");
props.setProperty("sslfactory","org.postgresql.ssl.NonValidatingFactory");





connection= DriverManager.getConnection(url, props);
}catch(Exception e){}
		return connection;
		
}
}

