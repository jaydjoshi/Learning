package com.learning.design;

public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton.getInstance();
		
		EnumSingleton s = EnumSingleton.INSTANCE;
	}

	private static Singleton instance;

	private Singleton() {

	}

	// 1st method lazy initialization
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;

	}

	// 2nd method synchronized
	public static synchronized Singleton getInstanceS() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;

	}

	// 3rd method double check singleton,
	// variable needs to be volatile
	public static Singleton getInstanceDCS() {
		
		if (instance == null) {
			synchronized (Singleton.class) {
				if(instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;

	}

}
