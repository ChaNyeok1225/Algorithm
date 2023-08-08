import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] obj = new int[n+1][2];
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			obj[i][0] = Integer.parseInt(st.nextToken());
			obj[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[k+1][n+1];
		
		for(int i = 1; i < k + 1; i++) {
			
			for(int j = 1; j < n + 1; j++) {
				D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
				if(obj[j][0] <= i) 
					D[i][j] = Math.max(D[i][j], obj[j][1] + D[i-obj[j][0]][j-1]);
				
			}
		}
		
		System.out.println(D[k][n]);
		
		////////////////////////////////////////////////////
		br.close();

	}

}

