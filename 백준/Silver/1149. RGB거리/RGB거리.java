import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[][] H = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				H[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[n][3];
		
		D[0][0] = H[0][0];
		D[0][1] = H[0][1];
		D[0][2] = H[0][2];
		
		for(int i = 1; i < n; i++) {
			D[i][0] = H[i][0] + Math.min(D[i-1][1], D[i-1][2]);
			D[i][1] = H[i][1] + Math.min(D[i-1][0], D[i-1][2]);
			D[i][2] = H[i][2] + Math.min(D[i-1][0], D[i-1][1]);
		}

		int res = Math.min(D[n-1][0], D[n-1][1]);
		res = Math.min(res, D[n-1][2]);
		
		System.out.println(res);
		
		
	}

}
