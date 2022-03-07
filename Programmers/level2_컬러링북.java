package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level2_컬러링북 {
	static int[][] picture;
	static int m,n;
	static int numberOfArea,maxSizeOfOneArea;
	
	public static void main(String[] args) {
        numberOfArea = 0; //영역의 개수
        maxSizeOfOneArea = 0; //가장 큰 영역 넓이
        
        m = 6;
        n= 4;
        
        picture = new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        bfs();
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;   
        
        System.out.println(answer[0] + " " + answer[1]);
	}
	
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static void bfs() {
    	boolean[][] visited = new boolean[m][n];
        Queue<POS> q = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(picture[i][j] == 0 || visited[i][j]) continue;
        		
        		q.add(new POS(i,j));
        		numberOfArea++;
        		visited[i][j] = true;
        		
        		int cnt = 1;
        		while(!q.isEmpty()) {
        			POS pos = q.poll();
        			
        			for(int d=0; d<4; d++) {
        				int x = pos.x+ dx[d];
        				int y = pos.y+ dy[d];
        				
        				if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || picture[x][y] == 0) continue;
        				
        				if(picture[x][y] == picture[pos.x][pos.y]) {
        					q.add(new POS(x,y));
        					cnt++;
        					visited[x][y] = true;
        				}       				
        			}
        		}
        		
        		maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
        		
        	}
        }
    }
	
    static class POS{
        int x,y;
        
        public POS(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
