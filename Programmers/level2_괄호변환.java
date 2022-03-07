package Solution;

import java.util.Stack;

public class level2_괄호변환 {
    static String answer = "";

    public static void main(String[] args) {
        String p = "()))((()";
        answer = change(p);
        System.out.println(answer);
    }

    static String change(String p) {
        StringBuilder w = new StringBuilder();
        w.append(p);

        //문자열을 u와 v로 나누기
        int cnt1 = 0;
        int cnt2 = 0;
        int idx = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt1++;
            if (p.charAt(i) == ')') cnt2++;
            if (cnt1 != 0 && cnt2 != 0 && cnt1 == cnt2) {
                idx = i;
                break;
            }
        }

        StringBuilder u = new StringBuilder(p.substring(0, idx + 1));
        StringBuilder v = new StringBuilder(p.substring(idx+1, p.length()));

        //u와 v가 올바른 문자열인지 균형잡힌 문자열인지 확인
        boolean uCheck = balance(u.toString());
        boolean vCheck = balance(v.toString());

        if(uCheck){
        	if(vCheck) answer = u.toString() + v.toString();
        	else answer += u + change(v.toString());
        }
        else {
        	if(vCheck) {
        		return "(" + v + ")" + u.reverse().substring(1,u.length()-1);
        	}else {
        		answer += "(" + change(v.toString()) + ")" + reverse(u.substring(1,u.length()-1));
        	}
        }

        return answer;
    }

    static boolean balance(String u) {
        Stack<Character> s = new Stack<>();
        
        if(u.length() == 0) return true;
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') s.push('(');
            else {
                if(s.isEmpty()) return false;
                if(s.peek() == '(') s.pop();
            }
        }

        if (!s.isEmpty()) return false;
        return true;
    }
    
    static String reverse(String str) {
    	String re = "";
    	
    	for(int i=0; i<str.length(); i++) {
    		if(str.charAt(i) == '(') re += ")";
    		else re += "(";
    	}
    	
    	return re;
    }

}
