import java.io.*;
import java.util.*;

//start	2023. 12. 21  15 : 52
//end 	2023. 12. 21  16 : 51
public class Main {
	
	static int n, ans = Integer.MAX_VALUE;
	static char[][] board;
	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        
        n = Integer.parseInt(br.readLine());
        
        
        board = new char[n][n];
        int[][] door = new int[2][2];
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
        	char[] str = br.readLine().toCharArray();
        	for(int j =0 ; j < n; j++) {
        		board[i][j] = str[j];
        		if(board[i][j] == '#') {
        			door[idx][0] = i;
        			door[idx++][1] = j;
        		}
        	}
        }
        
        Queue<int[]> q = new ArrayDeque<int[]>();
        boolean[][] vis = new boolean[n][n];
        
        for(int dir = 0; dir < 4; dir++)
        	q.offer(new int[] {door[0][0], door[0][1], dir, 0});
        
        
        int step, nx, ny;
        step = nx = ny = 0;
        
        loop : while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	
        	for(int dir = 0; dir < 4; dir++) {
        		step = 1;
        		while(true) {
        			
        			nx = cur[0] + dx[dir] * step;
        			ny = cur[1] + dy[dir] * step;
        			
        			if(valid(nx,ny) || board[nx][ny] == '*')
        				break;
        			
        			if(nx == door[1][0] && ny == door[1][1]) {
        				ans = cur[3];
        				break loop;
        			}
        			
        			if(board[nx][ny] == '!' && !vis[nx][ny]) {
        				vis[nx][ny] = true;
        				q.offer(new int[] {nx, ny, dir^0b11, cur[3]+1});
        				q.offer(new int[] {nx, ny, dir^1, cur[3]+1});
        			}
        			step++;
        		}
        	}
        }
        
        System.out.println(ans);
    }
    
    static boolean valid(int x, int y) {
    	return x < 0 || y < 0 || n <= x || n <= y;
    }
    
}