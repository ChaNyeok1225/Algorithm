import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int[][] info = new int[n + 1][2];

		int[] D = new int[n + 2];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = n; i > 0; i--) {
			
			if(info[i][0] + i <= n + 1) {
				D[i] = Math.max(D[i+info[i][0]] + info[i][1], D[i+1]);
				
			} else {
				D[i] = D[i+1];
			}

			if(D[i] > max)
				max = D[i];
		}


		System.out.println(max);

	}

}
