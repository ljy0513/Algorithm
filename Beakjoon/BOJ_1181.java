package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			if (list.contains(str)) continue; // 같은 문자열이 있다면 pass
			list.add(str);
		}

		//Comparator 쓰는 법 정리
		Comparator<String> compare = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) return -1;
				else if(o1.length() == o2.length()) {
					return o1.compareTo(o2); //compareTo 함수??
				}
				return 1;
			}
			
		};
		
		Collections.sort(list , compare);
		
		for(String str : list) {
			System.out.println(str);
		}

	}

}
