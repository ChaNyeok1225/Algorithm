import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n+1];
		
		for(int i = 0; i < n; i++)
			arr[i][0] = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		int sx,sy,ex,ey;
		int sum;
		while(m-- > 0) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			for(int i = sx; i <= ex; i++) {
				sum += arr[i-1][ey] - arr[i-1][sy-1];
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.print(sb);
	}
	
	
}