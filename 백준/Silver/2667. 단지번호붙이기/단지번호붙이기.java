import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = ch[j] - '0';
			}
		}

		LinkedList<int[]> q = new LinkedList<>();
		List<Integer> sizes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;

				if (map[i][j] == 1) {
					map[i][j] = 0;
					q.add(new int[] { i, j });
					cnt++;
				}

				while (!q.isEmpty()) {
					int[] p = q.pop();
					for (int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];

						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if (map[nx][ny] == 0)
							continue;

						map[nx][ny] = 0;
						q.add(new int[] { nx, ny });
						cnt++;

					}
				}
				if(cnt > 0)
					sizes.add(cnt);
			}
		}

		System.out.println(sizes.size());
		Collections.sort(sizes);
		for(int size : sizes)
			sb.append(size + "\n");
		System.out.println(sb);
		
	}
	

}
