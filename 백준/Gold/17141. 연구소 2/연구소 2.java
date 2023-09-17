import java.io.*;
import java.util.*;

public class Main {
	
	
	static int n, m, total, min, sel[], board[][];
	static ArrayList<int[]> vp = new ArrayList<>();
	static boolean vis[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		vis = new boolean[n][n];
		sel = new int[m];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] != 1)
					total++;
				if(board[i][j] == 2)
					vp.add(new int[] {i,j});
			}
		}
		
		comb(0, 0);
		
		if(min == Integer.MAX_VALUE) min = -1;
		
		System.out.println(min);
	}

	static void comb(int cnt, int idx) {
		
		if(cnt == m) {
			
			int fill = 0;
			int depth = 0;
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					vis[i][j] = false;
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			
			for(int i = 0; i < m; i++) {
				int[] p = vp.get(sel[i]);
				q.offer(new int[] {p[0],p[1], 0});
				vis[p[0]][p[1]] = true;
				fill++;
			}
			
			int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
			
			while(!q.isEmpty()) {
				int[] p = q.poll();
				
				for(int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];
					
					if(nx < 0 || ny < 0 || n <= nx || n <= ny)
						continue;
					if(board[nx][ny] == 1 || vis[nx][ny])
						continue;
						
					vis[nx][ny] = true;
					depth = p[2] + 1;
					fill++;
					q.offer(new int[] {nx,ny, depth});
				}
				
				if(depth >= min)
					break;
			}
			
			if(fill == total && min > depth)
				min =depth;
			
			return;
		}
		
		for(int i = idx; i < vp.size(); i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	
}