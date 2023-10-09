import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int res = 0;
		
		int[] f = new int[P.length];
		
		int j = 0;
		for(int i = 1; i < P.length; i++) {
			while(j > 0 && P[j] != P[i]) j = f[j-1];
			if(P[j] == P[i]) f[i] = ++j;
		}
		
		j = 0;
		for(int i = 0; i < S.length; i++) {
			
			
			while(j > 0 && P[j] != S[i]) j = f[j-1];
			if(P[j] == S[i])
				j++;
			
			if(j == P.length) {
				res = 1;
				break;
			}
		}
		
		System.out.println(res);
		
	}
	
}