import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] stair = new int[n+1];
		for(int i = 1; i < n+1; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		int[][] D = new int[n+1][3]; // [i][j], i:계단의 번호, j: 연속 밟은 횟수의 점수 총합
		
		D[1][1] = stair[1];
		D[1][2] = stair[1];
		
		for(int i = 2; i < n + 1; i++) {
			D[i][1] = stair[i] + Math.max(D[i-2][1],D[i-2][2]); 
			D[i][2] = stair[i] + D[i-1][1];
		}
		
		System.out.println(Math.max(D[n][1], D[n][2]));
		
	}

}
