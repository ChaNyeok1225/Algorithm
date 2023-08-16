import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] paper;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		paper = new int[n+1][2];
		int[] D = new int[n+1];
		
		paper[0][0] = 1000;
		paper[0][1] = 1000;
		D[0] = 0;
		for(int i = 1 ; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			paper[i][0] = Integer.parseInt(st.nextToken());
			paper[i][1] = Integer.parseInt(st.nextToken());
			D[i] = 1;
		}
		
		Arrays.sort(paper, (int[] a1, int[] a2) -> {
			return a2[0]*a2[1] - a1[0]*a1[1];
		});
		
//		for(int i = 0; i < n+1; i++)
//			System.out.println(Arrays.toString(paper[i]));
		
		int max = 1;
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 0; j < i; j++) {
				if(chk(i, j)) {
					D[i] = Math.max(D[i], D[j] + 1); 
					if(max < D[i])
						max = D[i];
				}
			}
		}		
		
		System.out.println(max);
		
	}

	private static boolean chk(int i, int j) {
		return (paper[i][0] <= paper[j][0] && paper[i][1] <= paper[j][1])
		|| (paper[i][0] <= paper[j][1] && paper[i][1] <= paper[j][0]);
	}
}
