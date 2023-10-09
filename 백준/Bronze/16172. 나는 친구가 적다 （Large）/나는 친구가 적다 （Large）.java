import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		char[] s = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		int[] f = new int[p.length];
		
		int j = 0;
		for(int i = 1; i < p.length; i++) {
			while(j > 0 && p[i] != p[j]) j = f[j-1];
			if(p[i] == p[j]) f[i] = ++j;
		}
		
		int res = 0;
		
		j = 0;
		for(int i = 0; i < s.length; i++) {
			if(!Character.isAlphabetic(s[i]))
				continue;
			
			while(j > 0 && s[i] != p[j]) j = f[j-1];
			if(s[i] == p[j]) j++;
			
			if(j == p.length) {
				res = 1;
				break;
			}
		}
		
		System.out.println(res);
		
	}
	
}