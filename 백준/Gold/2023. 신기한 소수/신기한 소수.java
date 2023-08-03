import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		prime(n, 0);
		
		System.out.println(sb);
	}

	private static void prime(int n, int num) {
		if(n == 0) {
			sb.append(num + "\n");
			return;
		}
		
		num *= 10;
		L : for(int i = 1; i < 10; i++) {
			int tmp = num + i;
			
			if(tmp == 1) continue L;
			for(int j = 2; j <= Math.sqrt(tmp); j++) {
				if(tmp % j == 0)
					continue L ;
			}
			prime(n-1, tmp);
		}
	}

	
}
