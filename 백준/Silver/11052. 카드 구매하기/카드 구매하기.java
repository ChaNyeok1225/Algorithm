import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());

		int[] D = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= i / 2; j++) {
				D[i] = Math.max(D[i], D[j] + D[i-j]);
			}
		}

		
		
		System.out.println(D[n]);

		////////////////////////////////////////////////////
		br.close();

	}

}
