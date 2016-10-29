package com.learning.leetcode.PhoneDirectory;

import java.util.Map;

public class PhoneDirectoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneDirectory phone = new PhoneDirectory();
		phone.add("abc", 9876543210l);
		phone.add("acb", 9000000000l);
		phone.add("cab", 9000000000l);
		phone.add("add", 9000000000l);
		
		Map<String,Long> map = phone.getEntireDirectory();
		
		map.forEach( (k,v) -> System.out.println("Name : "+k+"\tNumber: "+v ));
		
		String name = "abc";
		System.out.println("Number for "+name + " is "+phone.get("abc"));
		
		Map<String,Long> mapFilter = phone.getNameDirectory("^a*");
		mapFilter.forEach( (k,v) -> System.out.println("Name : "+k+"\tNumber: "+v ));
		/*
		Pattern p = Pattern.compile("a*");
		Matcher m = p.matcher("abc");
		System.out.println(m.find());*/
	}

}
