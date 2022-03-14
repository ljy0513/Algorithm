import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15900 {
    static List<ArrayList<Integer>> list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(new ArrayList<>());
        visited = new boolean[N];
        answer = 0;

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        dfs(0, 0);

        if (answer % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    static void dfs(int node, int cnt) {
        visited[node] = true;

        List<Integer> nodeList = list.get(node);
        boolean flag = true;
        for (int i = 0; i < nodeList.size(); i++) {
            if (visited[nodeList.get(i)]) continue;
            else{
                dfs(nodeList.get(i), cnt + 1);
                flag = false;
            }
        }

        // 가지고 있는 노드가 모두 이미 방문한 노드일 경우 -> 리프노드 cnt를 answer에 더함
        if(flag) answer += cnt;
        return;
    }
}
