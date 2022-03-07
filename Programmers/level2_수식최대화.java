package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level2_수식최대화 {
	static List<Character> opers,cpOpers;
	static List<Long> nums,cpNums;
	static char[] order;
	static char[] oper;
	static long answer;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		String expression = 
				"50*6-3*2";
				//"100-200*300-500+20";
		answer =0;
		oper = new char[] {'*','+','-'};
		order = new char[3];
		opers = new ArrayList<>();
		cpOpers = new ArrayList<>();
		nums = new ArrayList<>();
		cpNums = new ArrayList<>();
		isSelected = new boolean[3];
		
		String num = "";
		for(int i=0; i<expression.length(); i++) {
			char ch = expression.charAt(i);
			
			//숫자와 연산을 list에 순서대로 따로 저장한다
			if(ch >= '0' && ch <= '9') {
				num += ch;
				if(i == expression.length()-1) nums.add(Long.parseLong(num));
			}else {
				opers.add(ch);
				nums.add(Long.parseLong(num));
				num = "";
			}
		}
		
		copy();
		perm(0);
		System.out.println("answer : " + answer);

	}
	
	static void perm(int cnt) {
		if(cnt == 3) {
			//연산의 우선수위를 정한 후
			System.out.println("order : " + Arrays.toString(order));
			
			for(int i=0; i<order.length; i++) {
				System.out.println(cpNums);
				System.out.println(cpOpers);
				
				int j = 0;
				while(j < cpOpers.size()) {
					if(cpOpers.get(j) == order[i]) {
						long tmp = 0;
						if(order[i] == '*') {
							tmp = cpNums.get(j) * cpNums.get(j+1);
						}else if(order[i] == '+') {
							tmp = cpNums.get(j) + cpNums.get(j+1);
						}else {
							tmp = cpNums.get(j) - cpNums.get(j+1);
						}
						cpOpers.remove(j);
						cpNums.remove(j+1);
						cpNums.remove(j);
						cpNums.add(j, tmp);
						j = 0; //같은 연산이 있을 수 있으므로 연산list의 처음 부터 다시 탐색
					}else {
						j++;
					}
					
				}//while
			}		
			answer = Math.max(answer, Math.abs(cpNums.get(0))); //마지막으로 list에 남은 수가 최종 결과값, 절대값으로 비교
			copy();
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(isSelected[i]) continue;
			
			order[cnt] = oper[i];
			isSelected[i] = true;
			
			perm(cnt+1);
			isSelected[i] = false;	
		}
	}
	
	static void copy() {
		cpNums.clear();
		cpOpers.clear();
		for(Character ch : opers) {
			cpOpers.add(ch);
		}
		for(Long num : nums) {
			cpNums.add(num);
		}
	}
}
