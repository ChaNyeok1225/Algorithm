import java.io.*;
import java.util.*;

public class Main {

	static int n, ans1, ans2, board[][];
	static boolean vis[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		vis = new boolean[n][n];
		
		ArrayList<int[]> white = new ArrayList<>();
		ArrayList<int[]> black = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					
					if(i % 2 == j % 2)
						white.add(new int[] { i, j });
					else
						black.add(new int[] { i, j });
				}
			}
		}

		bt(0, 0, white, true);
		bt(0, 0, black, false);

		System.out.println(ans1+ans2);
	}


	static boolean chk(int x, int y) {
		
		for(int i = 1; i < n; i++) {
			
			if(0 <= x-i && 0 <= y-i)
				if(vis[x-i][y-i]) return false;
			
			if(0<= x-i && y+i < n)
				if(vis[x-i][y+i]) return false;
		}
		
		return true;
	}

	static void bt(int cnt, int idx, List<int[]> list, boolean flag) {
		
		if(flag && ans2 < cnt) 
			ans2 = cnt;
		else if(!flag && ans1 < cnt)
			ans1 = cnt;
		
		for (int i = idx; i < list.size(); i++) {
			int[] p = list.get(i);
			
			if(chk(p[0],p[1])) {
				vis[p[0]][p[1]]= true;
				bt(cnt+1, i+1, list, flag);
				vis[p[0]][p[1]] = false;
			}
		}

	}
}