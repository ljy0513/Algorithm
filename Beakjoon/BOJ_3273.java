package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(in.readLine());

        int start = 0;
        int end = N - 1;

        while (true) {
            if (start >= end) break;

            if (arr[start] + arr[end] == x) {
                answer++;
                start++;
                end--;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}
