package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class level2_전력망둘로나누기 {

	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		//완전탐색 : 간선을 하나씩 모두 끊어서 세줘야함
		
		//무방향 연결리스트 만들기
		int answer = n;
		List<List<Integer>> linkedlist = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			linkedlist.add(new ArrayList<>());
		}	
		for (int i = 0; i < wires.length; i++) {
			linkedlist.get(wires[i][0]).add(wires[i][1]);
			linkedlist.get(wires[i][1]).add(wires[i][0]);
		}
		
		for (int i = 0; i < wires.length; i++) {
			//간선 하나씩 끊기
			linkedlist.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
			linkedlist.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
			
			//개수 세기 -> 절대값 차이 갱신
			answer = Math.min(answer, Math.abs(2 * bfs(n, linkedlist) - n));
			
			//끊은 전선 복구
			linkedlist.get(wires[i][0]).add(wires[i][1]);
			linkedlist.get(wires[i][1]).add(wires[i][0]);
		}
		
		System.out.println(answer);
	}
	
	//개수 세기
	static int bfs(int n, List<List<Integer>> linkedlist) {
		int wiresCnt = 0;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		q.add(1);
		visited[1] = true;
		wiresCnt++;
		
		while(!q.isEmpty()) {
			int wire = q.poll();
			
			for(int i=0; i<linkedlist.get(wire).size(); i++) {
				int linkedWire = linkedlist.get(wire).get(i);
				if(!visited[linkedWire]) {
					q.add(linkedWire);
					visited[linkedWire] = true;
					wiresCnt++; //연결된 전선 개수 카운팅
				}
			}
		}
		
		return wiresCnt;
	}

}
