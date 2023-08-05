import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[][] tri = new int[n][];
		int[][] D = new int[n][];
		
		for(int i = n-1; i >= 0; i--) {
			tri[i] = new int[n-i];
			D[i] = new int[n-1];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n-i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		D[0] = tri[0].clone();
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n - i; j++)
				D[i][j] = tri[i][j] + Math.max(D[i-1][j], D[i-1][j+1]);
			
		}
		
		System.out.println(D[n-1][0]);
	}

}
