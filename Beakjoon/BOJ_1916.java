import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        List<ArrayList<Node>> list = new ArrayList<>();

        for (int i = 0; i < 1+N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e,w));
        }

        StringTokenizer st = new StringTokenizer(in.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[1+N];
        int[] dist = new int[1+N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        for (int i = 0; i < N; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for (int j = 0; j < list.get(nodeIdx).size(); j++) {
                Node adjNode = list.get(nodeIdx).get(j);
                if (dist[adjNode.e] > dist[nodeIdx] + adjNode.w) {
                    dist[adjNode.e] = dist[nodeIdx] + adjNode.w;
                }
            }
        }

        System.out.println(dist[endCity]);

    }

    static class Node {
        int e,w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
