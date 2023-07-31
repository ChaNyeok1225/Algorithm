import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[][] star;
	
	public static void main(String[] args) throws IOException {

		///////////////////// 구현부//////////////////////

		int n = Integer.parseInt(br.readLine());
		
		star = new char[n][2 * n - 1];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(star[i], ' ');
		
		func(n,0,n - 1);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2 * n -1; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	public static void func(int n, int x, int y) {
		 if(n == 3) {
			 star[x][y] = '*';
			 star[x+1][y-1] = '*';
			 star[x+1][y+1] = '*';
			 
			 for(int i = -2; i < 3; i++) {
				 star[x+2][y+i] = '*';
			 }
			 return;
		 }
		 
		func(n/2, x, y);
		func(n/2, x + n/2, y - n/2);
		func(n/2, x + n/2, y + n/2);
		
	}
	
}
