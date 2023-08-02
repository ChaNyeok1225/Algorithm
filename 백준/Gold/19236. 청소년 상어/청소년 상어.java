import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][][] board = new int[4][4][2];
	

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int max = 0;

	public static void main(String[] args) throws IOException {

		int num;
		int dir;
		
		HashMap<Integer, int[]> map = new HashMap<>();
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken()) - 1;

				board[i][j][0] = num;
				board[i][j][1] = dir;

				if (i == 0 && j == 0) {
					map.put(-1, new int[] { i, j });
					board[i][j][0] = -1;
					max += num;
				} else {
					map.put(num, new int[] { i, j });
				}
			}
		}

		recur(board, map, max);
		
		System.out.println(max);

	}

	static void recur(int[][][] lboard, HashMap<Integer, int[]> map, int sum) {
		if (sum > max)
			max = sum;

		moveFish(lboard, map);

		int[] shark = map.get(-1).clone();
		int sdir = lboard[shark[0]][shark[1]][1];

		for (int step = 1; step < 4; step++) {
			int nx = shark[0] + dx[sdir] * step;
			int ny = shark[1] + dy[sdir] * step;

			if (nx < 0 || ny < 0 || 4 <= nx || 4 <= ny)
				break;

			if (lboard[nx][ny][0] > 0) {

				int[][][] tboard = new int[4][4][2];
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						tboard[i][j] = lboard[i][j].clone();
				
				HashMap<Integer, int[]> tmap = (HashMap<Integer, int[]>) map.clone();
				
				
				int fn = tboard[nx][ny][0];
				tboard[nx][ny][0] = -1;
				tboard[shark[0]][shark[1]][0] = 0;
				tmap.put(-1, new int[] {nx,ny});
				tmap.remove(fn);
				
				recur(tboard, tmap, sum + fn);
				
				tmap.put(fn, new int[] {nx, ny});
				tmap.put(-1, new int[] {shark[0], shark[1]});
				tboard[shark[0]][shark[1]][0] = -1;
				tboard[nx][ny][0] = fn;
				
			}
		}
	}

	static void moveFish(int[][][] lboard, HashMap<Integer, int[]> map) {
		
		for (int i = 1; i <= 16; i++) {
			if (map.containsKey(i)) {
				int[] fp = map.get(i).clone();
				int fdir = lboard[fp[0]][fp[1]][1];

				for (int j = 0; j < 8; j++) {
					int nx = fp[0] + dx[fdir];
					int ny = fp[1] + dy[fdir];

					if (nx < 0 || ny < 0 || 4 <= nx || 4 <= ny || lboard[nx][ny][0] == -1) {
						fdir = (fdir + 1) % 8;
						continue;
					}
					
					lboard[fp[0]][fp[1]][1] = fdir;

					map.put(lboard[nx][ny][0], new int[] { fp[0], fp[1] });
					map.put(i, new int[] { nx, ny });

					int[] tmp = lboard[fp[0]][fp[1]].clone();
					lboard[fp[0]][fp[1]] = lboard[nx][ny].clone();
					lboard[nx][ny] = tmp;
					break;
				}
			}
		}
	}

}
