package Solution;

import java.util.PriorityQueue;

public class level2_더맵게 {

	public static void main(String[] args) {
		int answer = 0;
		int[] scoville = {1,2,3};
		int K = 10;
		
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int n : scoville) {
			pq.add(n);
            if(n == 0) cnt++;
		}
		
		 /*
		if(cnt == scoville.length && K != 0) answer = -1; //모두 0이고 K가 0이 아닐 때
        else if (K == 0) answer = 0;
        else{
            int n1=0,n2=0;
            while(true) {
                n1 = pq.poll();
                if(pq.isEmpty()){
                	if(n1 >= K) break;
                    answer = -1;
                    break;
                }
                if(n1 >= K) break;
                n2 = pq.poll();

                pq.add(n1 + n2 * 2);
                answer++;
            }
        }
		*/
		
		if(cnt == scoville.length && K != 0) answer = -1;
		else {
	        while(pq.peek()<=K) {
	            if(pq.size()==1) {
	            	answer = -1;
	            	break;
	            }
	            int a = pq.poll();
	            int b = pq.poll();
	            pq.offer(a+(b*2));
	            answer++;
	        }
		}
		
		System.out.println(answer);

	}

}
