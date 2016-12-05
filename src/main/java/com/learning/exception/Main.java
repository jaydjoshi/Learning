package com.learning.exception;

public class Main {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Checked e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		method2();
	}
	
	public static void method1() throws Checked {
		throw new Checked();
	}
	
	public static void method2(){
		throw new Runtime();
	}

}


class Checked extends Throwable{
	public Checked() {
		super();
	}
}

class Runtime extends RuntimeException{
	
	private static final long serialVersionUID = -660921868591020593L;

	public Runtime() {
		super();
	}
}