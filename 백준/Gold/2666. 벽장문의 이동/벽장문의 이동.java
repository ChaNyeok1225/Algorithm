import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int k, min = Integer.MAX_VALUE, inst[];

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] open = new int[2];

		open[0] = Integer.parseInt(st.nextToken());
		open[1] = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());
		inst = new int[k];
		for (int i = 0; i < k; i++)
			inst[i] = Integer.parseInt(br.readLine());

		dfs(0, 0, open[0], open[1]);

		System.out.println(min);
	}

	private static void dfs(int cnt, int mv, int d1, int d2) {
		
		if (cnt == k) {
			if (min > mv)
				min = mv;
			return;
		}
		
		dfs(cnt+1, mv + Math.abs(inst[cnt] - d1), inst[cnt], d2);
		dfs(cnt+1, mv + Math.abs(inst[cnt] - d2), d1, inst[cnt]);
		
	}

}
