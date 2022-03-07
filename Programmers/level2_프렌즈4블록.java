package Programers;

public class level2_프렌즈4블록 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int answer = 0;
        char[][] map = new char[m][n];
        boolean[][] delete = new boolean[m][n];
        boolean flag = false;
        
        // 문자열 문자로 쪼개기
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while(true) {
            // 블록이 4개인 위치 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if(map[i][j] == 'Z') continue; // 비어있는 곳이라면 패스
                    if (map[i][j] == map[i][j + 1] && map[i][j + 1] == map[i + 1][j + 1] && map[i + 1][j + 1] == map[i + 1][j]) {
                        delete[i][j] = delete[i + 1][j] = delete[i][j + 1] = delete[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            
            // 없앨 수 있는 블록이 없다면 끝
            if(!flag) break;
            
            // 없어져야하는 블록 Z로 바꿔주기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (delete[i][j]) {
                        map[i][j] = 'Z';
                        answer++;
                    }
                }
            }

            //블록 아래로 내리기
            for (int i = 0; i < n; i++) {
                for (int j = m-2; j >=0 ; j--) {
                    if(map[j][i] == 'Z') continue;

                    for (int k = j; k < m-1; k++) {
                        if(map[k][i] != 'Z' && map[k+1][i] == 'Z'){ // 내가 비어있지 않고 바로 아래 블럭이 비어있다면
                            map[k+1][i] = map[k][i]; // 아래블럭에 현재 블럭값을 넣어주고
                            map[k][i] = 'Z'; // 현재 블럭값을 비어있는것으로 표시
                        }else break;
                    }
                }
            }

            delete = new boolean[m][n];
            flag = false;
        }

        System.out.println(answer);
    }
}
