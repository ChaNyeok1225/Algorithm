import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		long[][] D = new long[n+1][11];
		
		Arrays.fill(D[1], 1);
		D[1][0] = 0;
		D[1][10] = 0;
		
		for(int i = 2; i < n + 1; i++) {
			D[i][0] = D[i-1][1];
			for(int j = 1; j < 10; j++) {
				D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1_000_000_000;
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++) {
			sum = (sum + D[n][i]) % 1_000_000_000;
		}
		
		System.out.println(sum);
	}

}
