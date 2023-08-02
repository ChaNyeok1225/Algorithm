import java.io.*;
import java.util.*;

public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder sb = new StringBuilder();
//	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int num;
		st = new StringTokenizer(br.readLine());
		arr[0] = 0;
		for(int i = 1; i < n+1; i++) {
			num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1] + num;
		}
		
		int s, e;
		int sum;
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			sum = arr[e] - arr[s-1];
			
			sb.append(sum+"\n");
		}
		
		System.out.print(sb);
	}
	
	
}