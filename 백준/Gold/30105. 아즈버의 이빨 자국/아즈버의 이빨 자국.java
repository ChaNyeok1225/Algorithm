import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());

		int[] pos = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
			map.put(pos[i], i);
		}

		int res = 0;
		for (int i = 1; i < n; i++) {
			int d = pos[i] - pos[0];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (map.containsKey(pos[j] + d) || map.containsKey(pos[j] - d))
					cnt++;
				else
					break;
			}
			
			if(cnt == n) {
				res ++;
				sb.append(d).append(" ");
			}
		}
		
		System.out.println(res);
		System.out.print(sb);

	}

}