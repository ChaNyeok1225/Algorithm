import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < n + 1; j++) {
				if (i == j)
					continue;
				graph[i][j] = 10000;
			}

		int[] items = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++)
			items[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (graph[f][t] > w) {
				graph[f][t] = w;
				graph[t][f] = w;
			}
		}

		for (int t = 1; t < n + 1; t++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					int sum = graph[i][t] + graph[t][j];
					if (sum < graph[i][j])
						graph[i][j] = sum;
				}
			}
		}

		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < n + 1; j++) {
				if (graph[i][j] <= m)
					cnt += items[j];
			}
			if (max < cnt)
				max = cnt;
		}

		System.out.println(max);

	}

}