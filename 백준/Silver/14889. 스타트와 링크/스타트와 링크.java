import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static StringTokenizer st;

	static int n;
	static boolean[] team;
	static int[][] stat;
	
	static int bal = 9999999;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		team = new boolean[n + 1];
		stat = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++)
				stat[i][j] = Integer.parseInt(st.nextToken());
		}

		func(0, 1, n / 2);
		System.out.println(bal);
	}
	
	static void func(int cnt, int idx, int end) {
		if(cnt == n/2) {
			int start = 0;
			int link = 0;
			for(int i = 1; i < n + 1; i++) {
				for(int j = i; j < n + 1; j++) {
					if(team[i] == team[j]) {
						if(team[i]) start += stat[i][j] + stat[j][i];
						else link += stat[i][j] + stat[j][i];
					}
				}
			}
			
			int b = Math.abs(start - link);
			if(b < bal)
				bal = b;
			
			return;
		}
		
		for(int i = idx; i < end; i++) {
			team[i] = true;
			func(cnt+1, i+1, n + 1);
			team[i] = false;
		}
	}

}
