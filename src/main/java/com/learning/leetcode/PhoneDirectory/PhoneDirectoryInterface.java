package com.learning.leetcode.PhoneDirectory;

import java.util.Map;

public interface PhoneDirectoryInterface {
	
	Long get(String name);
	Long add(String name, Long number);
	Map<String,Long> getEntireDirectory();
	Map<String,Long> getNameDirectory(String name);
	

}
