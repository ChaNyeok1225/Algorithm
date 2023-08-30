import java.io.*;
import java.util.*;

public class Solution {

	static int[][] dx = { { 0, 0 }, { 1, -1 } }, dy = { { 1, -1 }, { 0, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int[][][] dist = new int[201][201][2];
			dist[x1 + 100][y1 + 100][0] = dist[x1 + 100][y1 + 100][1] = 1;

			Queue<int[]> q = new ArrayDeque<int[]>();

			q.offer(new int[] { x1 + 100, y1 + 100, 0 });
			q.offer(new int[] { x1 + 100, y1 + 100, 1 });
			int res = 0;
			while (!q.isEmpty()) {
				int[] p = q.poll();

				if (p[0] == x2 + 100 && p[1] == y2 + 100) {
					res = dist[p[0]][p[1]][p[2]];
					break;
				}

				for (int dir = 0; dir < 2; dir++) {
					int nx = p[0] + dx[p[2]][dir];
					int ny = p[1] + dy[p[2]][dir];

					if (nx < 0 || ny < 0 || 200 < nx || 200 < ny)
						continue;

					if (dist[nx][ny][p[2] ^ 1] != 0)
						continue;

					dist[nx][ny][p[2] ^ 1] = dist[p[0]][p[1]][p[2]] + 1;
					q.offer(new int[] { nx, ny, p[2] ^ 1 });
				}
			}
			
//			for(int i = 95; i < 105; i++) {
//				for(int j = 95; j < 105; j++)
//					System.out.print(dist[i][j][0] + " " + dist[i][j][1] + ",  ");
//				System.out.println();
//			}
			
			System.out.printf("#%d %d\n", tc, res-1);
		}


	}

}
