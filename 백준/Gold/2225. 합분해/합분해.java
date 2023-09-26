import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] D = new int[k+1][n + 1];

		Arrays.fill(D[1], 1);
		
		for(int i  = 1 ; i < k + 1; i++)
			D[i][0] = 1;
		
		
		for(int i = 2; i < k+1; i++) {
			for(int j = 1; j < n + 1; j++) {
				for(int l = 0; l <= j; l++) {
					D[i][j] = (D[i][j] + D[i-1][l]) % 1_000_000_000;
				}
			}
		}
		System.out.println(D[k][n]);
	}
}