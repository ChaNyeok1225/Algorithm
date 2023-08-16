import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] lim = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			lim[i] = Integer.parseInt(st.nextToken());
		
		int score = 0;
		
		int speed = 0;
		for(int i = n-1; i >= 0; i--) {
			if(lim[i] <= speed)
				speed = lim[i];
			else
				speed++;
			
			score += speed;
		}
		
		System.out.println(score);
		
	}

}
