import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		a = b - a;
		int gcd = gcd(a,b);
		
		System.out.println(a/gcd + " " + b/gcd);
		
	}
	
	static int gcd(int a, int b) {
		while(b!=0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
		
	}
	
}