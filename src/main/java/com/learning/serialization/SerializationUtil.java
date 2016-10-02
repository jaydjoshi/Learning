package com.learning.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {
	
	public static Employee readObjectFromFile(String fileName) throws IOException{
		System.out.println("Inside readObjectFromFile");
		ObjectInputStream in = null;
		try {
			FileInputStream fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			
			return (Employee) in.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			in.close();
		}
		
		return null;
	}
	
	public static void writeObjectToFile(Employee object,String fileName){
		
		try {
			System.out.println("Inside writeObjectToFile");
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(object);
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
