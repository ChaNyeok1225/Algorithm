import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		long[] D = new long[n+1];
		D[1] = 1;
		
		for(int i = 2; i < n + 1; i++) 
			D[i] = D[i-1] + D[i-2];
		
		
		System.out.println(D[n]);
	}

}
