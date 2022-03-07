package Solution;

import java.util.HashMap;
import java.util.Map;

public class level2_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		Map<String,String> map = new HashMap<>();
		int cnt = 0;
		
		for (int i = 0; i < record.length; i++) {
			String[] order = record[i].split(" ");
			
			switch (order[0]) {		
			case "Enter":
				map.put(order[1],order[2]);
				cnt++;
				break;
			case "Leave":
				cnt++;
				break;
			case "Change":
				map.replace(order[1],order[2]);
				break;
			}
		}
		
		String[] answer = new String[cnt];
		int idx = 0;
		for(int i=0; i<record.length; i++) {		
			String[] order = record[i].split(" ");
			
			switch (order[0]) {		
			case "Enter":
				answer[idx++] = map.get(order[1])+ "님이 들어왔습니다.";
				break;
			case "Leave":
				answer[idx++] = map.get(order[1]) + "님이 나갔습니다.";
				break;
			case "Change":
				break;
			}			
		}
		
		for(String str : answer) {
			System.out.println(str);
		}
	}

}
