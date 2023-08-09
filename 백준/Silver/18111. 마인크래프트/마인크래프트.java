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
		int b = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		
		int min = 256;
		for(int i = 0; i < n; i++) {
//			br.readLine();
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(min > board[i][j])
					min = board[i][j];
			}
		}
		
		int h = min;
		int mintime = Integer.MAX_VALUE;
		while(true) {
			
			int tb = b;
			int totaltime = 0;
			int hdiff;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					
					hdiff = h - board[i][j];
					
					// 땅의 높이가 더 높으면 음수가 된다, 제거하는데 2초가 걸리고 블록추가
					if(hdiff < 0) {
						totaltime += hdiff * -2;
						tb += -hdiff;
					} else {
						totaltime += hdiff;
						tb -= hdiff;
					}
				}
			}
			
			// 블록이 부족해지면 break
			if(tb < 0)
				break;
			
			if(mintime >= totaltime) {
				mintime = totaltime;
				min = h;
			}
			
			h++;
		}
		
		System.out.println(mintime + " " +  min);
		
	}
}
