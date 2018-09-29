import java.util.*;

public class InFix {

  public static int precedence(char c) {
    if(c == '{' || c == '}' || c == '(' || c == ')' || c == '[' || c ==']')  return 4;
    if(c == '^')  return 3;
    if(c == '*' || c == '/')  return 2;
    if(c == '+' || c =='-')  return 1;
    return 0;
  }

  public static char openingBrackets(char c) {
    if(c == ')')  return '(';
    if(c == ']')  return '[';
    if(c == '}')  return '{';
    return 't';
  }

  public static boolean isOpening(char c) {
    if(c == '(' || c == '{' || c =='[')  return  true;
    return false;
  }

  public static boolean isOperator(char c) {
    if(c == '{' || c == '}' || c == '(' || c == ')' || c == '[' || c ==']' || c == '^' || c == '*' || c == '/' || c == '+' || c == '-' )  return true;
    return false;
  }

  public static void postfix(String exp) {
    String str = new String();
    Stack<Character> operators = new Stack<>();
    for(int i = 0; i < exp.length(); i++) {
      if(isOperator(exp.charAt(i)) == false) {
        str = str + exp.charAt(i);
      } 
      else {
        if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{') operators.push(exp.charAt(i));
        else if (exp.charAt(i) == ')' || exp.charAt(i) == ']' || exp.charAt(i) == '}') {
          while(operators.peek() != openingBrackets(exp.charAt(i))) {
            str = str + operators.peek();
            operators.pop();
          }
          operators.pop();
        } 
        else {
          if(operators.empty() || isOpening(operators.peek()) || (precedence(operators.peek()) < precedence(exp.charAt(i)))) {
            operators.push(exp.charAt(i));
          } 
          else {
            while(!operators.empty() && !isOpening(operators.peek()) && (precedence(operators.peek()) >= precedence(exp.charAt(i)))) {
              str = str + operators.peek();
              operators.pop();
            }
          }   
        }
      }
    }
    while(!operators.empty()) {
      str = str + operators.peek();
      operators.pop();
    }
    System.out.println(str);
  }

  public static void prefix(String exp) {
    String str = new String();
    Stack<Character> operators = new Stack<>();
    Stack<Character> characters = new Stack<>();
    for(int i = 0; i < exp.length(); i++) {
      if(isOperator(exp.charAt(i)) == false) {
        characters.push(exp.charAt(i));
      }
      else {
        if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{') operators.push(exp.charAt(i));
        else if (exp.charAt(i) == ')' || exp.charAt(i) == ']' || exp.charAt(i) == '}') {
          while(operators.peek() != openingBrackets(exp.charAt(i))) {
            str = str + operators.peek();
            operators.pop();
          }
          operators.pop();
        }
        else {
          if(operators.empty() || isOpening(operators.peek()) || (precedence(operators.peek()) < precedence(exp.charAt(i)))) {
            operators.push(exp.charAt(i));
          }
          else {
            while(!operators.empty() && !isOpening(operators.peek()) && (precedence(operators.peek()) >= precedence(exp.charAt(i)))) {
              str = str + operators.peek();
              operators.pop();
            }
          }
        }
      }
    }
    while(!operators.empty()) {
      str = str + operators.peek();
      operators.pop();
    }
    System.out.println(str);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String exp = sc.nextLine();
   // prefix(exp);
    postfix(exp);
    sc.close();
  }
}
