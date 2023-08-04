import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n+1];
		
		
		if(n < 3) {
			System.out.println(n);
			return;
		}
		D[1] = 1;
		D[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			D[i] = (D[i-1] + D[i-2])%10007;
		}
		System.out.println(D[n]);
	}

}
