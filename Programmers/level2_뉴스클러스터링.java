package Solution;

import java.util.ArrayList;
import java.util.List;

public class level2_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "1111";
		String str2 = "1111";
		
		//2글자씩 끊어서 다중 집합
		//대소문자 구분 X
		//영문자 쌍만 가능
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		List<String> str1Arr = new ArrayList<>();
		List<String> str2Arr = new ArrayList<>();
		
		String tmp = "";
		for (int i = 0; i < str1.length()-1; i++) {
			tmp = str1.substring(i,i+2);
			if((tmp.charAt(0) >= 'a' && tmp.charAt(0) <= 'z') && (tmp.charAt(1) >= 'a' && tmp.charAt(1) <= 'z')) {
				str1Arr.add(tmp);
			}
		}
		
		for (int i = 0; i < str2.length()-1; i++) {
			tmp = str2.substring(i,i+2);
			if((tmp.charAt(0) >= 'a' && tmp.charAt(0) <= 'z') && (tmp.charAt(1) >= 'a' && tmp.charAt(1) <= 'z')) {
				str2Arr.add(tmp);
			}
		}
		
		double intersection = 0;
		
		//교집합 개수 구하기
		if(str1Arr.size() <= str2Arr.size()) {
			for (int i = 0; i < str1Arr.size(); i++) {
				for (int j = 0; j < str2Arr.size(); j++) {
					if(str1Arr.get(i).equals(str2Arr.get(j))) {
						str1Arr.remove(i);
						str2Arr.remove(j);
						intersection++;
						i--;
						break;
					}
					
				}
			}
		}else {
			for (int i = 0; i < str2Arr.size(); i++) {
				for (int j = 0; j < str1Arr.size(); j++) {
					if(str1Arr.get(i).equals(str2Arr.get(j))) {
						str2Arr.remove(i);
						str1Arr.remove(j);
						intersection++;
						i--;
						break;
					}
					
				}
			}
		}
		
		//합집합 개수 구하기
		double union = intersection + str1Arr.size() + str2Arr.size();
		
		System.out.println(intersection + " " + union);
		
		int answer = 0;
		if(intersection == 0 && union == 0) answer = 65536;
		else answer = (int)((intersection / union) * 65536.0);
		System.out.println(answer);
		
		
	}

}
















