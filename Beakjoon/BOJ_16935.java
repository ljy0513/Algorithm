package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int[][] arr;
	static int N;
	static int M;
	static int R; // 연산 개수
	static int[][] transArr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 저장

		int oper;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < R; i++) {
			oper = Integer.parseInt(st.nextToken());

			switch (oper) {
			case 1:
				updown();
				break;
			case 2:
				leftright();
				break;
			case 3:
				rightTurn();
				break;
			case 4:
				leftTurn();
				break;
			case 5:
				clockWise();
				break;
			case 6:
				counterclockWise();
				break;
			}
		}//연산 수행
		
		//출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}//main
	
	static void updown() {
		int tmp;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = tmp;
			}
		}
	}//상하 반전

	static void leftright() {
		int tmp;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = tmp;
			}
		}
	}//좌우 반전
	
	static void rightTurn() {
		int x=0, y=0;
		transArr = new int [M][N];
		for(int i=0; i<M; i++) {
			for(int j=N-1; j>=0; j--) {
				transArr[x][y++] = arr[j][i];
			}
			y=0;
			x++;
		}
		
		int tmp = N;
		N = M;
		M = tmp;	
		arr = transArr;
	}//오른쪽 90도 회전
	
	static void leftTurn() {
		int x=M-1, y=0;
		transArr = new int [M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				transArr[x--][y] = arr[i][j];
			}
			x=M-1;
			y++;
		}
		
		int tmp = N;
		N = M;
		M = tmp;
		arr = transArr;
	}//왼쪽 90도 회전
		
	static void clockWise() {
		transArr = new int [N][M];
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				transArr[i][M/2+j] = arr[i][j];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				transArr[N/2+i][j] = arr[i][j];
			}
		}
		
		for(int i=N/2; i<N; i++) {
			for(int j=M/2,c=0; j<M; j++,c++) {
				transArr[i][c] = arr[i][j];
			}
		}
		
		for(int i=N/2,r=0; i<N; i++,r++) {
			for(int j=0; j<M/2; j++) {
				transArr[r][j] = arr[i][j];
			}
		}
		arr = transArr;
		
	}//시계방향으로 그룹이동
	
	static void counterclockWise() {
		transArr = new int [N][M];
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				transArr[N/2+i][j] = arr[i][j];
			}
		}
		
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				transArr[i][M/2+j] = arr[i][j];
			}
		}
		
		for(int i=N/2,r=0; i<N; i++,r++) {
			for(int j=M/2; j<M; j++) {
				transArr[r][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=M/2,c=0; j<M; j++,c++) {
				transArr[i][c] = arr[i][j];
			}
		}
		arr = transArr;
	}//반시계방향으로 그룹이동
	
}
