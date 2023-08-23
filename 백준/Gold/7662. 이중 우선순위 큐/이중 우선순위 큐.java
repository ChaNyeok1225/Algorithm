import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> tm = new TreeMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				char inst = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				switch (inst) {
				case 'I':
					tm.put(x, tm.getOrDefault(x, 0) + 1);
					break;
				case 'D':
					if (!tm.isEmpty()) {
						if (x == 1) {
							int key = tm.lastKey();
							int ex = tm.get(key);
							ex--;

							if (ex == 0)
								tm.remove(key);
							else
								tm.put(key, ex);

						} else if (x == -1) {
							int key = tm.firstKey();
							int ex = tm.get(key);
							ex--;

							if (ex == 0)
								tm.remove(key);
							else
								tm.put(key, ex);
						}
					}
				}
			}
			if(tm.isEmpty()) 
				sb.append("EMPTY");
			else 
				sb.append(tm.lastKey() + " " + tm.firstKey());
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
