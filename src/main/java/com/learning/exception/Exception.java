package com.learning.exception;

public class Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		System.out.println(returnVal());
		
		try {
			System.out.println(returnException());
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int returnVal(){
		try{
			//return 0;
			System.exit(0);
		}catch(Throwable e){
			return 1;
		}finally{
			return 2;
		}
	}
	
	public static int returnException() throws java.lang.Exception{
		try{
			throw new java.lang.Exception("0");
		}catch(Throwable e){
			throw new java.lang.Exception("1");
		}finally{
			throw new java.lang.Exception("2");
		}
	}

}


