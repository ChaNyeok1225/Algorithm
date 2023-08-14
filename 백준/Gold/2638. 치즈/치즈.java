import java.io.*;
import java.util.*;

public class Main {

	static Queue<int[]> q = new ArrayDeque<int[]>();
	static Queue<int[]> cp = new ArrayDeque<int[]>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] cheese[], air;
	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new boolean[n][m][2];
		air = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				cheese[i][j][0] = st.nextToken().equals("1") ? true : false;
		}

		q.offer(new int[] { 0, 0 });
		air[0][0] = true;

		int sec = 0;
		while (true) {

			airChk();

			if (cp.size() == 0)
				break;

			cheeseMelt();

			sec++;
		}

		System.out.println(sec);
	}

	private static void cheeseMelt() {

		while(!cp.isEmpty()) {
			int[] p = cp.poll();
			cheese[p[0]][p[1]][0] = false;
			q.offer(new int[] {p[0],p[1]});
		}
		
	}

	static void airChk() {

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || m <= ny || air[nx][ny])
					continue;

				if (cheese[nx][ny][0] && !air[nx][ny]) {
					if(!cheese[nx][ny][1]) cheese[nx][ny][1]=true;
					else {
						cp.offer(new int[] {nx,ny});
						air[nx][ny] = true;
					}
					continue;
				}
				
				air[nx][ny] = true;
				q.offer(new int[] { nx, ny });

			}

		}

	}

}
