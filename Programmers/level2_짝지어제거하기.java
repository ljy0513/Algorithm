package Solution;

import java.util.Stack;

public class level2_짝지어제거하기 {

	public static void main(String[] args) {
		String str = "baba";
		
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<str.length(); i++) {
			if(stack.isEmpty()) {
				stack.push(str.charAt(i));
				continue;
			}
			
			if(stack.peek() == str.charAt(i)) stack.pop();
			else stack.push(str.charAt(i));
		}
		
		if(!stack.isEmpty()) System.out.println("0");
		else System.out.println("1");
	}

}
