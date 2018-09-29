import java.util.Stack;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class BalancedParanthesis {

  static boolean check(String str) {
    Stack<Character> stack = new Stack<>();

    if(str.length() % 2 == 1) return false;

    for(int i = 0; i < str.length(); i++) {

      if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
        stack.push(str.charAt(i));
        if(stack.size() > (str.length() / 2)) return false;
      } 
      else {
        if(stack.empty() == true) return false;

        if((str.charAt(i) == '}' && stack.peek() == '{') || (str.charAt(i) == ')' && stack.peek() == '(') || (str.charAt(i) == ']' && stack.peek() == '[')) {
          stack.pop();
        } 
        else {
          return false;
        }
      }
    }
    return stack.empty();
  }
 
  public static void main(String args[]) {
   String str = new String();
   Scanner sc = new Scanner(System.in);
   str =  sc.next();
   boolean ans = check(str);
   if(ans == true) System.out.println("Balanced");
   else System.out.println("Not Balanced");
  }
}
