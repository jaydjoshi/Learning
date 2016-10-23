package com.learning.leetcode.PhoneDirectory;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory implements PhoneDirectoryInterface {
	
	private Map<String,Long> phoneDirectory = new TreeMap<>();

	@Override
	public Long get(String name) {
		// TODO Auto-generated method stub
		if(phoneDirectory.containsKey(name))
			return phoneDirectory.get(name);
		else
			return 0l;
	}

	@Override
	public Long add(String name, Long number) {
		// TODO Auto-generated method stub
		return phoneDirectory.put(name, number);
	}

	@Override
	public Map<String, Long> getEntireDirectory() {
		// TODO Auto-generated method stub
		return phoneDirectory;
	}	

	

}
