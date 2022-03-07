package Solution;

public class level2_큰수만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		
		StringBuilder maxNum = new StringBuilder(number);
		int cnt = 0;
		boolean flag = false;
		
		while(cnt < k) {
			for (int i = 0; i < maxNum.length()-1; i++) {
				if(maxNum.charAt(i)-'0' < maxNum.charAt(i+1) - '0') {
					maxNum.deleteCharAt(i);
					flag = true;
					break;
				}
			}
			//모든 숫자가 다 같을 경우
			if(!flag) {
				maxNum.delete(maxNum.length()-(k-cnt), maxNum.length());
				break;
			}else{
				cnt++;
				flag = false;
			}
		}
		
		String answer = maxNum.toString();
		System.out.println(answer);
	}
}

//100000 , 100001 , 999911 , 111119 k = 4
//10		11			99		19