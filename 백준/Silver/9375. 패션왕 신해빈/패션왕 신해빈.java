import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String k = st.nextToken();
				String l = st.nextToken();

				hm.put(l, hm.getOrDefault(l, 0) + 1);
			}
			
			int total = 1;
			
			for(String key : hm.keySet())
				total *= hm.get(key)+1;
			
			sb.append(total-1+"\n");

		}
		System.out.println(sb);
	}

}
