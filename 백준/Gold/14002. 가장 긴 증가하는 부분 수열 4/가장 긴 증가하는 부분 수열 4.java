import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int[][] D = new int[n][2];
		
		int lidx = n-1;
		int l = 1;
		
		for(int i = n-1; i >= 0; i--) {
			D[i][0] = 1;
			D[i][1] = i;
			for(int j = i + 1; j < n; j++) {
				if(nums[i] < nums[j]) {
					if(D[i][0] <= D[j][0]) {
						D[i][0] = D[j][0] + 1;
						D[i][1] = j;
						
						if(l < D[i][0]) {
							l = D[i][0];
							lidx = i;
						}
					}
				}
			}
		}
		
		
//		System.out.println(Arrays.toString(nums));
//		for(int i = 0; i < n; i++)
//			System.out.print(D[i][0] + " ");
//		System.out.println();
//		for(int i = 0; i < n; i++)
//			System.out.print(D[i][1] + " ");
//		System.out.println();
		
		sb.append(l+"\n");
		for(int i = 0; i < l; i++) {
			sb.append(nums[lidx] + " ");
			lidx = D[lidx][1];
		}
		
		System.out.println(sb);
	}

}
