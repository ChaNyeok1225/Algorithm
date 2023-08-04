import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static List<int[][]> list = new ArrayList<>();
	static boolean[] sel = new boolean[16];

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		putShape(0, 0);
		
		int max = 0;
		for(int i = 0; i <= n-4; i++) {
			for(int j = 0; j <= m-4; j++) {
				
				for(int [][] p : list) {
					int sum = 0;
					
					for(int [] xy : p ) {
						sum += board[i+xy[0]][j+xy[1]];
					}
					if(max < sum)
						max = sum;
				}
			}
		}
		
		System.out.println(max);

	}

	private static void putShape(int idx, int cnt) {
		if (cnt == 4) {
			int[][] tmp = new int[4][2];
			int sn = 0;
			for (int i = 0; i < 16; i++) {
				if (sel[i]) {
					tmp[sn][0] = i / 4;
					tmp[sn][1] = i % 4;
					sn++;
				}
			}
			if( chk(tmp) ) 
				list.add(tmp);
		}

		for (int i = idx; i < 16; i++) {
			sel[i] = true;
			putShape(i + 1, cnt + 1);
			sel[i] = false;
		}

	}

	private static boolean chk(int[][] points) {
		boolean flag = false;
		
		
		for(int i = 0; i < 4; i++) {
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(adj(points[i], points[j])) cnt++;
			}
			
			if (cnt == 0) return false;
			if (cnt >= 2) flag = true;
		}
		
		return flag;
	}

	private static boolean adj(int[] p1, int[] p2) {
		if(p1[0] == p2[0]) return Math.abs(p1[1] - p2[1]) == 1;
		if(p1[1] == p2[1]) return Math.abs(p1[0] - p2[0]) == 1;
		return false;
	}

}
