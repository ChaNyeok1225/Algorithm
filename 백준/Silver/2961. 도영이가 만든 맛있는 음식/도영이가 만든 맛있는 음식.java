import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int noc = 1 << n;

		int[][] ingredient = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		long min = 999999;
		for (int i = 1; i < noc; i++) {
			int tmp = i;
			long s = 1;
			long c = 0;

			for (int j = 0; j < n; j++) {

				if (tmp % 2 == 1) {
					s *= ingredient[j][0];
					c += ingredient[j][1];
				}
				tmp/=2;

			}
			
			if(min > Math.abs(s-c))
				min = Math.abs(s-c);
		}

		
		System.out.println(min);
		
	}

}
