import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
			
		
		int[] val = new int[n];
		for(int i = 0; i < n; i++)
			val[i] = Integer.parseInt(br.readLine());
		
		int[] D = new int[k+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] = 0;
		
		for(int i = 1; i < k + 1; i++) {
			for(int j = 0; j < n; j++) {
				if(i >= val[j]) {
					if(D[i-val[j]] != Integer.MAX_VALUE) {
						D[i] = Math.min(D[i], D[i-val[j]] + 1);
					}
				}
			}
		}
		
		if(D[k] == Integer.MAX_VALUE) D[k] = -1;
		System.out.println(D[k]);
		
	}

}
