import java.util.Stack;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class LongestValid {

	static int check(String str) {
		Stack<Character> stack = new Stack<>();
		int count = 0, maximumLength = 0;

		for(int i = 0; i < str.length(); i++) {

			if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
			} 
			else {
				if(stack.empty() == true) {
					continue;
				}

				if((str.charAt(i) == '}' && stack.peek() == '{') || (str.charAt(i) == ')' && stack.peek() == '(') || (str.charAt(i) == ']' && stack.peek() == '[')) {
					stack.pop();
					count += 2;
					if(stack.empty() == true && maximumLength < count) {
						maximumLength = count;  
						//            count = 0;
					}
				} 
				else {
					stack.clear();
					count = 0;
					continue;
				}
			}
		}
		if(maximumLength < count) return count;
		return maximumLength;
	}

	public static void main(String args[]) {
		//String str = new String();
		//Scanner sc = new Scanner(System.in);
		//str =  sc.next();
		int ans = check("()[]{}{(])}");
		assert ans ==60;
		System.out.println(ans);
	}
}
