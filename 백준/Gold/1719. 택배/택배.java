import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n + 1][n + 1];
		int[][] path = new int[n + 1][n + 1];

		int INF = 100000000;
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[f][t] = w;
			graph[t][f] = w;
			path[f][t] = t;
			path[t][f] = f;
		}


		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					int s = graph[i][k] + graph[k][j];
					if(graph[i][j] > s) {
						graph[i][j] = s;
						path[i][j] = path[i][k];
					}
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (graph[i][j] == 0)
					sb.append("-");
				else
					sb.append(path[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

}