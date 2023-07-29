import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] hy = { 2, 1, -1, -2, -2, -1, 1, 2 };

		int k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][] board = new int[h][w];
		int[][][] dist = new int[h][w][k + 1];
		boolean[][][] vis = new boolean[h][w][k];

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				Arrays.fill(dist[i][j], -1);

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		LinkedList<int[]> q = new LinkedList<>();
		for (int i = 0; i < k + 1; i++)
			dist[0][0][i] = 0;

		// x, y, 말처럼 뛴 횟수
		q.add(new int[] { 0, 0, 0 });
		
		
		int res = -1;
		while (!q.isEmpty()) {
			int[] p = q.pop();
//			System.out.println(Arrays.toString(p));
			if (p[0] == h - 1 && p[1] == w - 1) {
				res = dist[p[0]][p[1]][p[2]];
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || h <= nx || w <= ny)
					continue;
				if (board[nx][ny] == 1 || dist[nx][ny][p[2]] >= 0)
					continue;

				dist[nx][ny][p[2]] = dist[p[0]][p[1]][p[2]] + 1;
				q.add(new int[] { nx, ny, p[2] });
			}

			if (p[2] < k) {
				for (int dir = 0; dir < 8; dir++) {
					int nx = p[0] + hx[dir];
					int ny = p[1] + hy[dir];

					if (nx < 0 || ny < 0 || h <= nx || w <= ny)
						continue;
					if (board[nx][ny] == 1 || dist[nx][ny][p[2] + 1] >= 0)
						continue;

					dist[nx][ny][p[2] + 1] = dist[p[0]][p[1]][p[2]] + 1;
					q.add(new int[] { nx, ny, p[2] + 1 });
				}
			}
		}

//		for (int cnt = 0; cnt < k + 1; cnt++) {
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(dist[i][j][cnt] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		System.out.println(res);

		////////////////////////////////////////////////////
		br.close();
	}

}
