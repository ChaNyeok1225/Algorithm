import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = {1,0,-1,0}, dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[][] graph = new ArrayList[n][m];
		
		
		int[][] board = new int[n][m];
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j =0 ; j < m; j++) {
				board[i][j] = ch[j] - '0';
				graph[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					
					if(nx < 0 || ny < 0 || n <= nx || m <= ny)
						continue;
					
					graph[i][j].add(new int[] {nx,ny, board[nx][ny]});
				}
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2]);
		
		boolean[][] vis = new boolean[n][m];
		int[][] minEdge = new int[n][m];
		for(int i = 0; i < n; i++)
			Arrays.fill(minEdge[i], Integer.MAX_VALUE);
		minEdge[0][0] = 0;
		q.offer(new int[] {0,0,minEdge[0][0]});
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cp = q.poll();
			
			if(vis[cp[0]][cp[1]]) continue;
			
			vis[cp[0]][cp[1]] = true;
			if(++cnt==n*m)
				break;
			
			for(int[] np : graph[cp[0]][cp[1]]) {
				if(vis[np[0]][np[1]]) continue;
				
				if(minEdge[np[0]][np[1]] > minEdge[cp[0]][cp[1]] + np[2]) {
					minEdge[np[0]][np[1]] = minEdge[cp[0]][cp[1]] + np[2];
					q.offer(new int[] {np[0], np[1], minEdge[np[0]][np[1]]});
				}
			}
		}
		
		System.out.println(minEdge[n-1][m-1]);
		
	}
}
