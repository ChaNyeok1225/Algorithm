import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] score = new int[1_000_001];
		boolean[] chk = new boolean[1_000_001];
		int[] card = new int[n];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			chk[card[i]] = true;
			if(max < card[i])
				max = card[i];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = card[i]*2; j < max+1; j+=card[i]) {
				score[j]--;
				if(chk[j])
					score[card[i]]++;
			}
		}
		
		for(int i = 0; i < n; i++)
			sb.append(score[card[i]] + " ");
		System.out.println(sb);
		
		
	}
	

}