package Solution;

public class level3_기지국설치 {

	public static void main(String[] args) {
		int n = 12;
		int[] stations = //{9};
			{1,3,5,10,11};
		int w = 1;
		
		int answer = 0;
		int start = 0;
		int end = 0;
		int dis = w * 2 + 1;
		
		for(int i=0; i<stations.length; i++) {
			start = stations[i] - w;
			if(start < 2 || start <= end || start - 1 == end) {
				end = stations[i] + w;
				continue;
			}
			answer += (start - end - 1) / dis;
			if((start - end - 1) % dis != 0) answer += 1;
			end = stations[i] + w;
		}
        
        if(end < n) {
            answer += (n - end) / dis;
            if((n - end) % dis != 0) answer += 1;
        }
        
		System.out.println(answer);
		

	}
	

}
