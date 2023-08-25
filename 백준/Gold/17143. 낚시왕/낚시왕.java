import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] board, tmp;
	static HashMap<Integer, int[]> hm = new HashMap<>();
	static int r, c, m, res;

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[r + 1][c + 1];
		tmp = new int[r+1][c+1];

		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			board[sr][sc] = i;
			hm.put(i, new int[] { sr, sc, s, d-1, z });
		}

		for (int i = 1; i < c + 1; i++) {
//			for(int x = 1; x < r +1; x++)
//				System.out.println(Arrays.toString(board[x]));
//			System.out.println();
			fishing(i);

			moveShark();
		}
		System.out.println(res);
	}

	private static void moveShark() {
		for(int i = 1; i < r+1; i++)
			Arrays.fill(tmp[i], 0);
		
		for (int i = 1; i < m+1; i++) {
			if (!hm.containsKey(i))
				continue;
			
			int[] shark = hm.get(i);
			int dis = 0;
			
			int mv = shark[2];
			if(shark[3] == 0 || shark[3] == 1)  
				dis = r;
			else if(shark[3] == 2 || shark[3] == 3)  
				dis = c;
			
			mv %= (dis*2-2);
			
			int step = 0;
			while(step < mv)  {
				int nx = shark[0] + dx[shark[3]];
				int ny = shark[1] + dy[shark[3]];
				
				if(nx < 1 || ny < 1 || r+1 <= nx || c+1 <= ny) {
					shark[3] ^= 1;
					continue;
				}
				
				shark[0] = nx;
				shark[1] = ny;
				step++;
			}
			
			if(tmp[shark[0]][shark[1]] != 0) {
				if(shark[4] > hm.get(tmp[shark[0]][shark[1]])[4]) {
					hm.remove(tmp[shark[0]][shark[1]]);
					tmp[shark[0]][shark[1]] = i;
					hm.put(i, shark);
				} else {
					hm.remove(i);
				}
			} else {
				tmp[shark[0]][shark[1]] = i;
			}
		}

		for(int i = 1; i < r+1; i++) {
			for(int j = 1; j < c+1; j++)
				board[i][j] = tmp[i][j];
		}
		
	}

	private static void fishing(int pos) {
		for (int i = 1; i < r + 1; i++) {
			if (board[i][pos] != 0) {
				res += hm.get(board[i][pos])[4];
				hm.remove(board[i][pos]);
				break;
			}
		}
	}

}