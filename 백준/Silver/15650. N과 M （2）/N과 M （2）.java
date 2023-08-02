import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		re(1,0); 
		System.out.print(sb);
	}
	
	static void re(int idx, int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i < n+1; i++) {
			arr[cnt] = i;
			re(i+1, cnt+1);
			
		}
		
	}
}