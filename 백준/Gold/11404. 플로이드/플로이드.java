import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < n + 1; j++) {

				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = 10_000_000;
			}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[f][t] = Math.min(graph[f][t], w);
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < n + 1; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (graph[i][j] >= 10_000_000)
					sb.append(0);
				else
					sb.append(graph[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}