import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][k + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());

			for (int j = 1; j < k + 1; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

//		for(int i = 1; i < n+1;i++)
//			System.out.println(Arrays.toString(arr[i]));

		int[][] D = new int[n + 1][k + 1];
		int[][] use = new int[n + 1][k + 1];

		for (int i = 1; i < n + 1; i++) {
			D[i][1] = arr[i][1];
			use[i][1] = i;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 2; j < k + 1; j++) {

				D[i][j] = D[i][j - 1];
				use[i][j] = -1;

				for (int l = 1; l <= i; l++) {
					if (arr[l][j] + D[i - l][j - 1] > D[i][j]) {
						D[i][j] = arr[l][j] + D[i - l][j - 1];
						use[i][j] = l;
					}
				}
			}
		}

//		for (int i = 0; i < n + 1; i++)
//			System.out.println(Arrays.toString(D[i]));
//		System.out.println("**");
//		for (int i = 0; i < n + 1; i++)
//			System.out.println(Arrays.toString(use[i]));

		System.out.println(D[n][k]);
		LinkedList<Integer> link = new LinkedList<Integer>();
		
		int w = n;
		int idx = k;
		while(idx > 0) {
			if(use[w][idx] == -1) {
				link.offerFirst(0);
				idx--;
			} else {
				link.offerFirst(use[w][idx]);
				w -= use[w][idx];
				idx--;
			}
		}
		for(int path : link)
			sb.append(path + " ");
		System.out.println(sb);
	}

}
