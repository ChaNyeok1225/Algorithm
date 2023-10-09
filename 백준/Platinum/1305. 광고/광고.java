import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int l = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		
		int[] f = new int[l];
		
		int j = 0;
		for(int i = 1; i < l; i++) {
			while(j > 0 && s[i] != s[j]) j = f[j-1];
			if(s[i] == s[j]) f[i] = ++j;
		}
		System.out.println(l - f[l-1]);
	}
	
}