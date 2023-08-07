import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int k = 0;
		while (true) {
			k++;
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int[][] D = new int[n][3];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			D[0][0] = 1001;
			D[0][2] += D[0][1];
			
			for (int i = 1; i < n; i++) {
				D[i][0] += min(D[i-1][0], D[i-1][1]);
				D[i][1] += min(D[i-1][0], D[i-1][1], D[i-1][2], D[i][0]);
				D[i][2] += min(D[i-1][1], D[i-1][2], D[i][1]);
			}

			
//			for(int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(D[i]));
			
			sb.append(k + ". " + D[n - 1][1]+"\n");
		}
		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();

	}
	
	static int min (int ...nums) {
		int res = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			res = Math.min(res, nums[i]);
		}
		
		return res;
	}

}
