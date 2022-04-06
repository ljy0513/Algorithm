import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.get(i).add(1);
                } else{
                    list.get(i).add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }

                if(i == N-1 && j == K-1) answer = list.get(i).get(j);
            }
        }

        System.out.println(answer);
    }
}
