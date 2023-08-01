import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[][] group;
	
	static int res = 0;
	static int[][] arr = new int[7][2]; 
	static boolean[][] vis = new boolean[5][5];

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		group = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < 5; j++) {
				group[i][j] = ch[j];
			}
		}
		
		comb(0, 0, 0);
		
		System.out.println(res);
		
		////////////////////////////////////////////////////
		br.close();
	}

	static void comb(int idx, int cnt, int cntY) {
		if(cntY > 3)
			return;
		if(cnt == 7) {
			chk();
			return;
		}
		
		for(int i = idx; i < 25; i++) {
			arr[cnt][0] = i / 5;
			arr[cnt][1] = i % 5;
			
			if(group[i/5][i%5] == 'Y')
				comb(i+1, cnt+1, cntY + 1);
			else
				comb(i+1, cnt+1, cntY);

		}
		
	}
	
	static void chk() {
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			Arrays.fill(vis[i], false);
		
		for(int i = 0; i < 7; i++) {
			vis[arr[i][0]][arr[i][1]] = true;
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		LinkedList<int[]> q = new LinkedList<>();
		
		q.add(arr[0]);
		cnt++;
		vis[arr[0][0]][arr[0][1]] = false;
		while(!q.isEmpty()) {
			int[] p = q.pop();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || 5 <= nx || 5 <= ny)
					continue;
				if(vis[nx][ny] == false)
					continue;
				
				q.add(new int[] {nx,ny});
				vis[nx][ny] = false;
				cnt++;
			}
		}
		
		if(cnt == 7)
			res++;
		
	}

}
