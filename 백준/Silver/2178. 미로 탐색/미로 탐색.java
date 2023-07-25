import java.awt.List;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] maze = new int[n][m];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				maze[i][j] = ch[j] - '0';

			}
		}

		LinkedList<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] p = q.pop();

			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (maze[nx][ny] == 0)
					continue;

				if (maze[nx][ny] == 1) {
					maze[nx][ny] = maze[p[0]][p[1]] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}
		
		System.out.println(maze[n-1][m-1]);
	}

}
