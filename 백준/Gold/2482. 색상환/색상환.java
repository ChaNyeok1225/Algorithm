import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] D = new int[n+1][n+1];
		
		for(int i = 1; i < n + 1; i++)
			D[i][1] = i;
		
		for(int i = 4; i < n + 1; i++) {
			for(int j = 2; j <= i/2 && j <= k; j++) {
				D[i][j] = (D[i-1][j] + D[i-2][j-1]) % 1_000_000_003;
			}
		}
		
		System.out.println(D[n][k]);
	}
	


}