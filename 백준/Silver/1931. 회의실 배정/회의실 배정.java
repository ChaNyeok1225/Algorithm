import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		int[][] tt = new int[n][2];

		for (int i = 0; i < n; i++) {
//			br.readLine();
			st = new StringTokenizer(br.readLine());
			tt[i][0] = Integer.parseInt(st.nextToken());
			tt[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tt, (int[] a1, int[] a2) -> {
			if (a1[1] == a2[1])
				return a1[0] - a2[0];
			return a1[1] - a2[1];
		});
		
		int cnt = 0;
		int time = 0;
		for(int i = 0; i < n; i++) {
			if(time > tt[i][0]) continue;
			
			time = tt[i][1];
			cnt++;
		}

//		for (int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(tt[i]));

		System.out.println(cnt);
		////////////////////////////////////////////////////
		br.close();

	}

}
