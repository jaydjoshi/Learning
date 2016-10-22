package com.learning.leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 *
 */
public class AddDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits1(2999373));
	}
	
	public static int addDigits(int num) {
        int digit=0;
        while(num!=0){
            int temp = num%10;
            digit= digit+temp;
            num = num/10;
            if(num == 0 && digit >9){
            	num=digit;
            	digit=0;
            }
        }
        return digit;
        
    }
	
	//better approach
	public static int addDigits1(int num) {
	if (num==0) 
		return 0;
	else if (num%9==0)
		return 9;
	else
	    return num%9;  
	}
}
