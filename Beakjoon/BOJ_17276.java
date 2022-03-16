import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17276 {
    static int[][] map,copy;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            copy = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = map[i][j];
                }
            }
            rotate(n, d);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(copy[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }//testcase

        System.out.println(sb);

    }

    static void rotate(int n, int d) {
        if(d<0) d += 360;
        d /= 45;

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < n; j++) { // 이 규칙이 중요 ㅜㅜ
                copy[j][n/2] = map[j][j];
                copy[j][j] = map[n/2][j];
                copy[n/2][j] = map[n-j-1][j];
                copy[n-j-1][j] = map[n-j-1][n/2];
            }

            // 다음 회전을 위해 map으로 현재 상태를 저장
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = copy[j][k];
                }
            }
        }

    }

}
