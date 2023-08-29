import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] app = new int[n + 1][2];
		int totalsize = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++)
			app[i][0] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			app[i][1] = Integer.parseInt(st.nextToken());
			totalsize += app[i][1];
		}

		int[][] D = new int[totalsize + 1][n + 1];
		int res = 0;
		L : for (int i = 1; i < totalsize + 1; i++) {
			for (int j = 1; j < n+1; j++) {
				D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
				if (i >= app[j][1]) {
					D[i][j] = Math.max(D[i][j], D[i-app[j][1]][j-1] + app[j][0]);
				}
			}
			if(D[i][n] >= m) {
				res = i;
				break L;
			}
		}
		
		System.out.println(res);
		
	}

}
