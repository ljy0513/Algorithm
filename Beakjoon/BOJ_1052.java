import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (true) {
            int cnt = 0; // 만들 수 있는 최소의 물병 개수 카운팅
            int now = N; // 현재의 물병 개수

            // 현재의 물병의 개수에서 만들 수 있는 최소의 물병 개수 bottle
            while (now > 0) {
                if (now % 2 != 0) cnt++;
                now /= 2;
            }

            // 최소의 물병 개수가 K 보다 작다면
            if (cnt <= K) break;
            // 물병을 하나씩 구매해서 다시 확인
            answer++;
            N += 1;
        }

        System.out.println(answer);
    }
}
