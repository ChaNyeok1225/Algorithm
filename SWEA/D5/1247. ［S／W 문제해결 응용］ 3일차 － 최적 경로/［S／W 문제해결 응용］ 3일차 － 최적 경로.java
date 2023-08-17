import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int n = Integer.parseInt(br.readLine());
			int[][] customer = new int[n][2];

			st = new StringTokenizer(br.readLine());
			
			int[] company = new int[2];
			for(int i = 0; i < 2; i++)
				company[i] = Integer.parseInt(st.nextToken());
			
			int[] home = new int[2];
			for(int i = 0; i < 2; i++)
				home[i] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < 2; j++)
					customer[i][j] = Integer.parseInt(st.nextToken());
			
			int[] perm = new int[n];
			for(int i = 0; i < n; i++)
				perm[i] = i;
			
			int min = Integer.MAX_VALUE;
			
			do {
				int dist = 0; 
				int[] cur = company;
				for(int i = 0 ; i < n; i++) {
					dist += Math.abs(cur[0] - customer[perm[i]][0]) + Math.abs(cur[1] - customer[perm[i]][1]);
					cur = customer[perm[i]];
				}
				
				dist += Math.abs(cur[0] - home[0]) + Math.abs(cur[1] - home[1]);
				
				if(dist < min)
					min = dist;
				
			} while(np(perm));
			
			System.out.printf("#%d %d\n",tc,min);
			
		}

	}

	private static boolean np(int[] p) {
		
		int i, j ,k ;
		
		i = j = k = p.length-1;
		
		while(i >0 && p[i-1] >= p[i])
			i--;
		
		if(i==0) return false;
		
		while(p[i-1] >= p[j])
			j--;
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		while(i < k) {
			tmp = p[i];
			p[i] = p[k];
			p[k] = tmp;
			i++; k--;
		}
		
		return true;
	}

}
