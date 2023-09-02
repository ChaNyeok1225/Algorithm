import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, p[];
	
	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());
		
		p = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			p[i] = Integer.parseInt(st.nextToken());
		
		int cut = Integer.parseInt(br.readLine());
		
		del(cut);
		p[cut] = -2;
		
		boolean[] leaf = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(p[i] < 0)continue;
			leaf[p[i]] = true;
		}
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			if(p[i]!=-2 && !leaf[i])
				res++;
		}
		
//		System.out.println(Arrays.toString(leaf));
//		System.out.println(Arrays.toString(p));
		System.out.println(res);
		
	}
	
	static void del(int v) {
		
		for(int i = 0; i < n; i++) {
			if(p[i] == v) {
				del(i);
				p[i] = -2;
			}
		}
		
	}

}