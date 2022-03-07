package Solution;

import java.util.Stack;

public class level2_괄호회전하기 {

	public static void main(String[] args) {
		String s = "}]()[{";

		int answer = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			// 검사
			for (int j = 0; j < s.length(); j++) {
				char bracket = s.charAt(j);
				if (!stack.empty()) {
					if ((bracket == '}' && stack.peek() == '{') || (bracket == ']' && stack.peek() == '[')
							|| (bracket == ')' && stack.peek() == '('))
						stack.pop();
					else
						stack.push(bracket);
				} else
					stack.push(bracket);
			}

			if (stack.empty())
				answer++;

			//System.out.println(answer + " " + s);
			// 회전
			StringBuilder sb = new StringBuilder(s);
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
			s = sb.toString();
			stack.clear();
		}

		System.out.println(answer);
	}

}
