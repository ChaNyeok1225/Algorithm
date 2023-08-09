import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	static int[][] board = new int[1005][1005];

	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T + 1; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			HashMap<Integer, int[]> hm = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				st =new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					hm.put(board[i][j], new int[] {i,j});
				}
			}
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			boolean[] vis = new boolean[n*n+1];
			int max = 0;
			int roomnum = 0;
			
			for(int i = 1; i <= n*n; i++) {
				int cnt = 0;
				if(vis[i]) continue;
				int[] p = hm.get(i);
				q.offer(p);
				cnt++;
				
				while(!q.isEmpty()) {
					p = q.poll();
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || n <= ny)
							continue;
						if(board[nx][ny] != (board[p[0]][p[1]] + 1))
							continue;
						
						q.add(new int[] {nx, ny});
						vis[board[nx][ny]] = true;
						cnt++;
					}
					
				}
				if(max < cnt) {
					roomnum = i;
					max = cnt;
				}
				
			}
			
			System.out.printf("#%d %d %d\n",tc, roomnum,max);
			
		}
		
	}

}