import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            // M = 가로, N = 세로 K = 배추 개수
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(){
        int answer = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] || map[i][j] == 0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i,j});
                visited[i][j] = true;

                while (!q.isEmpty()){
                    int[] pos = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int x = pos[0] + dx[d];
                        int y = pos[1] + dy[d];

                        if(x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || map[x][y] == 0) continue;
                        q.add(new int[] {x,y});
                        visited[x][y] = true;
                    }
                }
                answer++;
            }
        }

        return answer;
    }

}
