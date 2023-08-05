import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] am = new int[n+3];
		
		int total = 0;
		for(int i = 0; i < n; i++) {
			am[i] = Integer.parseInt(br.readLine());
			total += am[i];
		}
		
		if(n < 3) {
			System.out.println(total);
			return;
		}
		
		int[] D = new int[n];
		D[0] = am[0]; D[1] = am[1]; D[2] = am[2];
		
		int m;
		for(int i = 3; i < n; i++) {
			m = Math.min(D[i-1], D[i-2]);
			D[i] = am[i] + Math.min(m, D[i-3]);
		}
//		System.out.println(Arrays.toString(D));
		m = Math.min(D[n-1], D[n-2]);
		System.out.println(total - Math.min(m, D[n-3]));
		
	}

}
