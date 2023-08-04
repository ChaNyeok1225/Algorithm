import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[][] D = new int[n + 1][2];

		D[1][0] = 0;
		for (int i = 2; i <= n; i++) {
			D[i][0] = D[i-1][0] + 1;
			D[i][1] = i-1;

			if(i % 2 == 0) {
				if(D[i][0] > D[i/2][0] + 1) {
					D[i][0] = D[i/2][0] + 1;
					D[i][1] = i/2;
				} 
			}
			if(i % 3 == 0) {
				if(D[i][0] > D[i/3][0] + 1) {
					D[i][0] = D[i/3][0] + 1;
					D[i][1] = i/3;
				} 
			}
			
		}

		sb.append(D[n][0]+"\n");

		int num = n;
		while(true) {
			sb.append(num+" ");
			if(num == 1)
				break;
			num = D[num][1];
		}
		System.out.println(sb);
	}

}
