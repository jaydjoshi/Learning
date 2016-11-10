package com.learning.dataStructure.stack;

import java.util.Scanner;

/**
 * check if the passed string of brackets is valid or not
 * valid - (()(())())
 * invalid - )(())()(
 */

public class ValidBracketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner s = null;
	boolean continueBool= true;
	while(continueBool){
			
			System.out.println("Enter bracket string:");
			
			s = new Scanner(System.in);
			String str = s.nextLine();
			
			boolean validBracket = checkBracketValid(str);
			
			if(validBracket)
				System.out.println("valid bracket string");
			else
				System.out.println("invalid bracket string");
			
			System.out.println("\n\nDo you wish to continue?\nPress n for NO");
			String continueStr = s.nextLine();
			
			
			if("N".equalsIgnoreCase(continueStr)){
				continueBool=false;
			}
		}
	
		System.out.println("System closed!");
		
		s.close();
	}

	/**
	 * @param str
	 * @return
	 */
	
	private static boolean checkBracketValid(String str) {
		// TODO Auto-generated method stub
		Stack stack=null;
		if(str.isEmpty())
			return false;
		else if(!(str.contains("(") && str.contains(")")))
			return false;
		else{
			stack=new Stack();
			char[] arr = str.toCharArray();
			for (char c : arr) {
				if('('==c)
				{
					stack.push(c);
				}
				else if(')'==c){
					if(stack.isEmpty())
						return false;
					stack.pop();
				}
			}
			if(stack.isEmpty())
				return true;
		}
 		
		return false;
	}

}
