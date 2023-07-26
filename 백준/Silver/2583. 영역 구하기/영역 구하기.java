import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sn = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			
			for (int j = sm; j < em; j++)
				for (int l = sn; l < en; l++)
					board[j][l] = true;
		}
	
//		for(boolean[] b : board)
//		System.out.println(Arrays.toString(b));
			
		int cnt = 0;
		int size = 0;
		List<Integer> sizes = new ArrayList<>();
		LinkedList<int[]> q = new LinkedList<>();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				size = 0;
				if(board[i][j] == false) {
					board[i][j] = true;
					q.add(new int[] {i,j});
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] p = q.pop();
					size++;
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || m <= ny)
							continue;
						if(board[nx][ny] == true)
							continue;
						
						board[nx][ny] = true;
						q.add(new int[] {nx,ny});
						
					}
				}
				if(size > 0)
					sizes.add(size);
				
			}
		
		System.out.println(cnt);
		Collections.sort(sizes);
		for(int i = 0; i < sizes.size(); i++)
			sb.append(sizes.get(i) + " ");
		System.out.println(sb);
		
//		for(boolean[] b : board)
//			System.out.println(Arrays.toString(b));
		

	}

}
