import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] cards = new int[21];
		
		for(int i = 1; i < 21; i++)
			cards[i] = i;
		
		int s, e, tmp;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			while(s < e) {
				tmp = cards[s];
				cards[s] = cards[e];
				cards[e] = tmp;
				s++; e--;
			}
		}
		
		for(int i = 1; i < 21; i++)
			sb.append(cards[i] +" ");
		System.out.println(sb);
	}
}