import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] arr = new int[6][3];
	static int[] team = new int[6];
	static int ans = 0;
	static boolean flag = false;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {

		for (int t = 0; t < 4; t++) {
			ans = 0;
			int sum = 0;
			flag = false;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				sum = 0;
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];
				}

				if (sum != 5)
					flag = true;
			}

			if (!flag)
				dfs(0, 0, 1);

			System.out.print(ans + " ");
		}

	}

	static void dfs(int idx, int cnt, int m) {
		if(flag) return;
		
//		for(int i = 0; i < 6; i++)
//			System.out.println(Arrays.toString(arr[i]));
//		System.out.println();
		
		
		if (cnt == 15) {
			ans = 1;
			flag = true;
			return;
		}

		if (arr[idx][0] + arr[idx][1] + arr[idx][2] == 0)
			dfs(idx + 1, cnt, idx + 2);
		else {

			for (int i = 0; i < 3; i++) {
				for (int j = m; j < 6; j++) {
					if (arr[idx][i] > 0 && arr[j][2 - i] > 0) {
						arr[idx][i]--;
						arr[j][2 - i]--;
						dfs(idx, cnt + 1, j + 1);
						arr[idx][i]++;
						arr[j][2 - i]++;
					}
				}
				
				
				
			}

		}

	}

}
