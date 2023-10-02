import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] b = new int[n];
		for(int i = 0; i<n; i++)
			b[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(b);
		int m = Integer.parseInt(br.readLine());
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			if(m / (n-i) < b[i]) {
				res = m/(n-i);
				break;
			} else
				res = b[i];
			m -= b[i];
		}
		
		System.out.println(res);
	}
	
}