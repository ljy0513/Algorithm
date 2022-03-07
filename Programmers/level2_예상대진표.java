package Solution;

public class level2_예상대진표 {

	public static void main(String[] args) {
		int n = 16;
		int a = 9;
		int b = 12;
		
		int start = 1;
		int end = n;
		int mid = 0;
		int answer = 0;
		
		while(n != 1) {
			n/=2;
			answer++;
		}
		
		while(answer != 1) {
			mid = (start + end) / 2;
			boolean A = range(a,start,end);
			boolean B = range(b,start,end);
			
			if(A != B) {	
				break;
			}else if(A && B) { //절반 중 a,b 모두 앞쪽에 있음
				end = mid;
			}else {
				start = mid+1;
			}
			answer--;
		}
		
		System.out.println(answer);
		
	}
	
	static boolean range (int num, int start, int end) {
		if(start <= num && num <= (start + end) / 2) {
			return true;
		}
		return false;
	}

}
