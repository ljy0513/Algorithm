package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();

		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == 'c') {
				/*	if (i + 1 < str.length() && str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')
				 * &&는 앞에가 참이 아니면 넘어가지만  || 는 뒤에 조건을 확인 하기 때문에
					i + 1 < str.length() && str.charAt(i + 1) == '=' -> 이렇게 처리하고 만약 참이 아니라면
					뒤의 조건 str.charAt(i + 1) == '-' -> 이걸 확인하기 때문에 StringIndexOutOfBounds 에러 발생*/
						
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-'))
					i++;
			} else if (ch == 'd') {
				if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')
					i += 2;
				else if (i + 1 < str.length() && str.charAt(i + 1) == '-')
					i++;

			} else if (ch == 'l' || ch == 'n') {
				if (i + 1 < str.length() && str.charAt(i + 1) == 'j')
					i++;
			} else if (ch == 's' || ch == 'z') {
				if (i + 1 < str.length() && str.charAt(i + 1) == '=')
					i++;
			}
			res++;

		}

		System.out.println(res);
	}
}
