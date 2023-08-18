import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			num[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i < n; i++) {
			num[i] = gcd(num[i-1], num[i]);
		}
		
		System.out.println(num[n-1]);

	}
	
	static int gcd(int a, int b) {
		while(b != 0) {
			int tmp = b;
			b = a%b;
			a = tmp;
		}		
		return a;
	}

}
