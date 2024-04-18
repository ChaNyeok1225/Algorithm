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

		int INF = 100000000;
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[f][t] = w;
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					graph[i][j] = graph[i][j] < graph[i][k] + graph[k][j] ? graph[i][j] : graph[i][k] + graph[k][j];
				}
			}
		}
		
		int min = 100000000;
		
		for(int i = 1; i < n + 1; i++) 
			min = min < graph[i][i] ? min : graph[i][i];
		
		if(min >= 100000000)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}