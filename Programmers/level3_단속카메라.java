package Programers;

import java.util.Arrays;
import java.util.Comparator;

public class level3_단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = routes[0][1]; //진출 지점
        for (int i = 1; i < routes.length; i++) {
            if(end < routes[i][0]) {
                answer++;
                end = routes[i][1]; // 다음 차의 진출지점으로 변경
            }
        }

        System.out.println(answer);
    }
}
