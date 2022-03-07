package Solution;

public class level2_조이스틱 {	
	
	public static void main(String[] args) {
		String name = "BBBBAABBB";
		boolean[] checked = new boolean[name.length()];
		int res = 0;
		
		for(int i=0; i<name.length(); i++) {
			char ch = name.charAt(i);
			if(ch == 'A') checked[i] = true;
			
			if(ch >= 'A' && ch <= 'N') res += ch - 'A';
			else res += 'Z' - ch + 1;		
		}
		
		boolean flag = true;
		int cur = 0;
		checked[cur] = true;
		
		while(flag) {
			int left=cur,right=cur;
			int cnt = 0;
			flag = false;
			
			while(cnt <= name.length()) {
				right+=1;
				left-=1;
				
				if(right >= name.length()) right = 0;
				if(left < 0) left = name.length()-1;
				cnt++;
				
				if(!checked[left] || !checked[right]) {
					res += cnt;
					if(!checked[right]) cur = right;
					else cur = left;
					checked[cur] = true;
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(res);
	}
}
