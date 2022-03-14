import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) return o1 < o2 ? -1 : 1;
                return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
            }
        });

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(in.readLine());

            if (n == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(n);
            }
        }

        System.out.println(sb);
    }
}
