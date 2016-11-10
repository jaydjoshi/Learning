package com.learning.design;

public class AbstarctInterfaceDemo extends AbstractDemo implements InterfaceDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstarctInterfaceDemo ab = new AbstarctInterfaceDemo();
		ab.iMethod1();
		ab.iMethod2();
		ab.method2();
		ab.method1();
	}

	@Override
	public void iMethod1() {
		// TODO Auto-generated method stub
		System.out.println("Main class - iMetod1");
	}

	@Override
	public void iMethod2() {
		// TODO Auto-generated method stub
		System.out.println("Main class - iMetod2");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Main class - Metod2");
		
	}
	
	@Override
	void method1() {
		// TODO Auto-generated method stub
		System.out.println("Main class - Metod1");
	}

}


abstract class AbstractDemo{
	
	void method1(){
		System.out.println("Method1 - Abstract class");
	}
	
	abstract void method2();
}

interface InterfaceDemo{
	void iMethod1();
	void iMethod2();
}