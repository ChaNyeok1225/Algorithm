import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n+3];
		
		D[0] = 1;
		D[1] = 3;
		D[2] = 7;
		
		for(int i = 2; i < n + 1; i++) {
			D[i] = (2*D[i-1] + D[i-2]) % 9901;
		}
		
		System.out.println(D[n]);
		
	}
	
}