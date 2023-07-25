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
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] box = new int[n][m];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		LinkedList<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				if(box[i][j] == 1)
					q.add(new int[] {i,j});
			}
		

		while (!q.isEmpty()) {
			int[] p = q.pop();
			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (box[nx][ny] == -1)
					continue;

				if (box[nx][ny] == 0) {
					box[nx][ny] = box[p[0]][p[1]] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}
		
		int day = 0;
		
		l : for(int[] arr : box) {
			for(int x : arr) {
				if (day < x)
					day = x;
				else if (x == 0) {
					day = 0;
					break l;
				}
			}
		}
		
		System.out.println(day-1);
	}

}
