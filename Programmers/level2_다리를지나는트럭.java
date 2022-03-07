package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level2_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		int answer = 0;
		Queue<Integer> q = new LinkedList<>();

		int total = 0;
		int idx = 0;

		while (true) {
			if(idx == truck_weights.length) {
				answer += bridge_length;
				break;
			}
			
			//다리 길이만큼 트럭이 올라갔을 경우 (트럭이 빠짐과 동시에 다음 순서의 트럭이 올라옴)
			if(q.size() == bridge_length) {
				total -= q.poll();
			}
			
			//다리에 트럭이 올라갈 수 있을 때
			if(q.size() < bridge_length) {
				//올라가야하는 트럭의 무게와 현재 다리에 올라와있는 트럭의 무게의 합이 다리의 하중보다 작을 경우
				if(total + truck_weights[idx] <= weight) {
					q.add(truck_weights[idx]);
					total += truck_weights[idx];
					idx++;
				}
				//다리의 하중을 초과할 경우 0을 넣어준다.
				else {
					q.add(0);			
				}
				answer++;
			}
		}

		System.out.println(answer);
	}

}
