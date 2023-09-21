import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[] val = new int[n];
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
			ts.add(val[i]);
		}
		
		int min = Integer.MAX_VALUE;
		int[] k = new int[2];
		for(int i = 0; i < n; i++) {
			ts.remove(val[i]);
			Integer a = ts.ceiling(-val[i]);
			if(a != null) {
				if(min > Math.abs(-val[i] - a)) {
					min = Math.abs(-val[i] - a);
					k[0]=val[i];
					k[1]=a;
				}
			}
			
			Integer b = ts.floor(-val[i]);
			if(b != null) {
				if(min > Math.abs(-val[i] - b)) {
					min = Math.abs(-val[i] - b);
					k[0]=val[i];
					k[1]=b;
				}
			}
			
			ts.add(val[i]);
		}
		
		Arrays.sort(k);
		System.out.println(k[0] + " " + k[1]);
	}
}