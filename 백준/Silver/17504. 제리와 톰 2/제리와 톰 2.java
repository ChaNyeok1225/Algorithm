import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		long a = 1, b = num[n-1];
		
		for(int i = n-2; i >= 0; i--) {
			
			a = a + num[i] * b;
			
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		a = b - a;
		long gcd = gcd(a,b);
		System.out.println(a/gcd +" "+b/gcd);
		
	}
	
	static long gcd(long a, long b) {
		while(b!=0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
	
}