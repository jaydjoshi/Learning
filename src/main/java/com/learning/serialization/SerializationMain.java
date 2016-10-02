package com.learning.serialization;

import java.io.IOException;

public class SerializationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee();
		emp.setAge(25);
		emp.setName("Jay");
		emp.setSalary(45000);
		
		String fileName = "C:/Jay/Personnel work/Learning/learning/src/main/java/com/learning/serialization/employeeSerialized.txt";
		String fileName1 = "C:/Jay/Personnel work/Learning/learning/src/main/java/com/learning/serialization/employeeSerialized.ser";
		
		SerializationUtil.writeObjectToFile(emp,fileName1);
		
		System.out.println("Object serialized "+emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.hashCode());
		
		Employee emp2 = null;
		try {
			emp2 = SerializationUtil.readObjectFromFile(fileName1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Object deserialized "+emp2.getName());
		System.out.println(emp2.getSalary());
		System.out.println(emp2.hashCode());

	}

}
