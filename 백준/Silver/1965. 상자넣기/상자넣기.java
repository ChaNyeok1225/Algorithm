import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] box = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			box[i] = Integer.parseInt(st.nextToken());

		int[] D = new int[n];
		Arrays.fill(D,1);

		
		int res = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (box[i] > box[j]) {
					D[i] = Math.max(D[i], D[j] + 1);
					if(res < D[i])
						res = D[i];
				}

			}
		}
		
		System.out.println(res);

	}

}