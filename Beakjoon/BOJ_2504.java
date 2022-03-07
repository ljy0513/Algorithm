package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String st = in.readLine();
      int num = 1;
      int sum = 0;
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < st.length(); i++) {
         if (st.charAt(i) == '(') {
            stack.add(st.charAt(i));
            num *= 2;
         } else if (st.charAt(i) == '[') {
            stack.add(st.charAt(i));
            num *= 3;
         } else if (!stack.isEmpty()&&stack.peek() == '(' && st.charAt(i) == ')') {
            if(st.charAt(i-1)=='(') sum += num;
            num /= 2;
            stack.pop();
         } else if (!stack.isEmpty()&&stack.peek() == '[' && st.charAt(i) == ']') {
            if(st.charAt(i-1)=='[') sum += num;
            num /= 3;
            stack.pop();
         } else {
            stack.add(st.charAt(i));
            break;
         }
            
      }
      if (!stack.isEmpty())
         System.out.println(0);
      else
         System.out.println(sum);

   }
}

/*
*	괄호안에 다른 괄호가 생길때마다 감싸고 있는 괄호의 값을 곱해줌
*	
*
*
*/
 