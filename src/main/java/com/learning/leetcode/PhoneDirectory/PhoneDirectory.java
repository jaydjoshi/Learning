package com.learning.leetcode.PhoneDirectory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@Override
	public Map<String, Long> getNameDirectory(String name) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(name);
		Matcher m = null;
		Map<String,Long> filterPhoneDirectory = new TreeMap<>();
		for (Entry<String, Long> element : phoneDirectory.entrySet()) {
			m = p.matcher(element.getKey());
			if(m.matches())
				filterPhoneDirectory.put(element.getKey(), element.getValue());			
		}
		
		
		return filterPhoneDirectory;
	}	

	

}
