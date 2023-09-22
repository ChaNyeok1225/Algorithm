import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] A = new int[n];
			int[] B = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				A[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++)
				B[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(B);
			
			int idx = 0;
			int res = 0;
			for(int i = 0; i < n; i++) {
				int v = A[i];
				
				while(idx < m && B[idx] < v)
					idx++;
				
				res += idx;
			}
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		
	}
}