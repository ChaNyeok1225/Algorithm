import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////


		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())
						+ arr[i-1][j]
						+ arr[i][j-1] 
						- arr[i-1][j-1] ;
			}
		}
		int sum;
		while(m-- > 0) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			sum = arr[ex][ey] - arr[sx-1][ey] - arr[ex][sy-1] + arr[sx-1][sy-1];
			
			sb.append(sum+"\n");
			
		}
		
        System.out.print(sb);
		
		br.close();
	}


}
