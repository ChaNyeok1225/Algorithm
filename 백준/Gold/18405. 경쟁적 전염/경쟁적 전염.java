import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]>[] pq = new PriorityQueue[2];
		pq[0] = new PriorityQueue<>((a,b) -> a[2] - b[2]);
		pq[1] = new PriorityQueue<>((a,b) -> a[2] - b[2]);
		
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] > 0)
					pq[0].offer(new int[] {i,j,board[i][j]});
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		
		for(int t = 0; t < s; t++) {
			PriorityQueue<int[]> tpq = pq[t%2];
			while(!tpq.isEmpty()) {
				int[] cur = tpq.poll();
				
				for(int dir = 0; dir < 4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] > 0)
						continue;
					
					board[nx][ny] = cur[2];
					pq[(t+1)%2].offer(new int[] {nx,ny,cur[2]});
				}
			}
		}
		System.out.println(board[x-1][y-1]);
	}
}