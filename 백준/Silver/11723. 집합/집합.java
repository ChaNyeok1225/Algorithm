import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		HashSet<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {

			case "add":
				set.add(st.nextToken());
				break;

			case "remove":
				set.remove(st.nextToken());
				break;

			case "check":
				if (set.contains(st.nextToken()))
					sb.append("1\n");
				else
					sb.append("0\n");
				break;

			case "toggle":
				String s = st.nextToken();
				if (set.contains(s))
					set.remove(s);
				else
					set.add(s);
				break;

			case "all":
				for(int i = 1; i <= 20; i++)
					set.add(String.valueOf(i));
				break;

			case "empty":
				set.clear();
				break;
			}

		}

		System.out.println(sb);
		
	}

}
