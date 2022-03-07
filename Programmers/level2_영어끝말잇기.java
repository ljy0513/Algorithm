package Solution;

import java.util.Arrays;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2]; // 번호, 차례
		int turn = 1;
		int order = 1;

		for (int i = 1; i < words.length; i++) {
			order++;
			
//			words[i - 1].substring(words[i - 1].length() - 1) != words[i].substring(0, 1)); --> equals로 해야함
			
			// 앞의 단어와 이어지는지 or 중복되는 단어인지 확인			
			if (!words[i - 1].substring(words[i - 1].length() - 1).equals(words[i].substring(0, 1)) || contains(i, words)) {
				answer[0] = order;
				answer[1] = turn;
				return answer;
			}

			// 둘다 해당하지 않는다면 다음 순서로 넘어감
			if (order % n == 0) {
				turn++;
				order = 0;
			}
		}
		return answer;
	}

	static boolean contains(int now_word, String[] words) {
		for (int i = 0; i < now_word; i++) {
			if (words[now_word].equals(words[i])) {
				System.out.println("들어가");
				return true;
			}
		}
		return false;
	}
}

public class level2_영어끝말잇기 {
	public static void main(String[] args) {
		int n = 3;
		String[] words = //{"hello", "one", "even", "never", "now", "world", "draw"};
			//{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish",
			//				"hang", "gather", "refer", "reference", "estimate", "executive"};
			{ "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

		Solution solution = new Solution();
		int[] answer = solution.solution(n, words);
		System.out.println(Arrays.toString(answer));
	}
}
