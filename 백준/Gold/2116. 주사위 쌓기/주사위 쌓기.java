import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dice = new int[n][6];
		
		for(int i = 0; i<n; i++) {
			st = new  StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] tb = {5,3,4,1,2,0};
		
		int max = 0;
		for(int i = 0; i < 6; i++) {
			int total = 0;
			int topNum = dice[0][i];
			int topidx = i;
			
			for(int j = 0; j < n; j++) {
				int dmax = 0;
				for(int k = 0; k < 6; k++)
					if(dice[j][k] == topNum) {
						topidx = k;
						break;
					}
				
				for(int k = 0; k < 6; k++) {
					if(k == topidx || k == tb[topidx])
						continue;
					if(dmax < dice[j][k%6])
						dmax = dice[j][k%6];
				}
				topNum = dice[j][tb[topidx]];
				
				total += dmax;
			}
			if(max < total)
				max = total;
		}
		
		System.out.println(max);
		
	}

}
