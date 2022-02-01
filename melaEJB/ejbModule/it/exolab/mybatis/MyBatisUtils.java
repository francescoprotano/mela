package it.exolab.mybatis;

//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.BufferedReader;
//import org.apache.ibatis.io.Resources;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;
import java.net.URL;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	
	private static SqlSessionFactory factory;
	 
	 private MyBatisUtils() {
	 }
	 
	 static
	 {
	  Reader reader = null;
	  try {
		  
		  
		  URL url = MyBatisUtils.class
			        .getClassLoader()
			        .getResource("mybatis-config.xml");
		  
			    
			if(url == null) {
			        throw new IllegalArgumentException("  not found 1");
			}
			    
		   File file = new File(url.getFile()); 
		  
		  String resource = url.getFile();
		  
		  if(!file.exists()){
			  throw new Exception("File not found");
			  
		  }
		 
	     reader = new FileReader(resource);
		  
		  
		  
	
	  } catch (IOException e) {
	   throw new RuntimeException(e.getMessage());
	  } catch (Exception e) {
		e.printStackTrace();
	}
	  factory = new SqlSessionFactoryBuilder().build(reader);
	 }
	 
	 public static SqlSessionFactory getSqlSessionFactory() 
	 {
	  return factory;
	 }
	 
	 
	
	
}
