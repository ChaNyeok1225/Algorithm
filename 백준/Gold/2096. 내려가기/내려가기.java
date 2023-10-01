import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] score = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			score[i][0] = Integer.parseInt(st.nextToken());
			score[i][1] = Integer.parseInt(st.nextToken());
			score[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] maxD = new int[n][3];
		int[][] minD = new int[n][3];
		
		for(int i = 0; i < 3; i++)
			maxD[0][i] = minD[0][i] = score[0][i];
		
		for(int i = 1; i < n; i++) {
			maxD[i][0] = Math.max(maxD[i-1][0], maxD[i-1][1]) + score[i][0];
			minD[i][0] = Math.min(minD[i-1][0], minD[i-1][1]) + score[i][0];
			
			maxD[i][1] = Math.max(maxD[i-1][0], Math.max(maxD[i-1][1],maxD[i-1][2])) + score[i][1];
			minD[i][1] = Math.min(minD[i-1][0], Math.min(minD[i-1][1],minD[i-1][2])) + score[i][1];
			
			maxD[i][2] = Math.max(maxD[i-1][1], maxD[i-1][2]) +score[i][2];
			minD[i][2] = Math.min(minD[i-1][1], minD[i-1][2]) +score[i][2];
		}
		
		int mins = Integer.MAX_VALUE;
		int maxs = 0;
		
		for(int i = 0; i < 3; i++) {
			if(mins > minD[n-1][i])
				mins= minD[n-1][i];
			if(maxs < maxD[n-1][i])
				maxs = maxD[n-1][i];
		}
		
		System.out.println(maxs + " " + mins);
		
	}
	
}