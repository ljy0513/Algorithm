import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int answer = 0;

        // 시작하는 시간 기준으로 정렬
        // 시작 시간이 같으면 빨리 끝나는 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] < o2[1] ? -1 : 1;
                else if (o1[0] < o2[0]) return -1;
                return 1;
            }
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] time = new int[2];
            time[0] = Integer.parseInt(st.nextToken()); //시작 시간
            time[1] = Integer.parseInt(st.nextToken()); //끝나는 시간
            pq.add(time);
        }

//        for (int i = 0; i < N; i++) {
//            int[] tmp = pq.poll();
//            System.out.println(tmp[0] + ", " + tmp[1]);
//        }

        PriorityQueue<Integer> tq = new PriorityQueue<>(); // 종료 시간
        int end = 0;
        for (int i = 0; i < N; i++) {
            int[] time = pq.poll();

            tq.add(time[1]);
            end = time[1];

            answer = Math.max(answer, tq.size());

        }

    }
}
