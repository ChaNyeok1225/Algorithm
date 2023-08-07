import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] D = new int[n+1][10];
		for(int i = 0; i < 10; i++)
			D[1][i] = 1;
		
		for(int i = 2; i < n + 1; i++) {
			D[i][0] = D[i-1][0];
			for(int j = 1; j < 10; j++) {
				D[i][j] = (D[i-1][j] + D[i][j-1]) % 10007;
			}
		}
		
		int total = 0;
		for(int i = 0; i < 10; i++)
			total = (total + D[n][i]) % 10007;
		
		System.out.print(total);
		
		////////////////////////////////////////////////////
		br.close();

	}

}

