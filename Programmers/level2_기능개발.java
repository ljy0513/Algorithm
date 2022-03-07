package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class level2_기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 99, 99, 99 };
		int[] speeds = { 1, 1, 1 };
		List<Integer> list = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			int day = 0;
			if ((100 - progresses[i]) % speeds[i] == 0) {
				day = (100 - progresses[i]) / speeds[i];
			} else {
				day = (100 - progresses[i]) / speeds[i] + 1;
			}
			q.add(day);
		}

		int day = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			day++;
			while (!q.isEmpty() && day >= q.peek()) {
				q.poll();
				cnt++;
			}
			if (cnt > 0)
				list.add(cnt);
			cnt = 0;
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));
	}

}
