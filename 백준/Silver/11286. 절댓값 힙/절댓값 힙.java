import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> q = new PriorityQueue<>((int[] n1, int[] n2) -> {
			if (n1[0] == n2[0])
				return n1[1] - n2[1];
			return n1[0] - n2[0];
		});

		while (n-- > 0) {
			int ins = Integer.parseInt(br.readLine());

			if (ins == 0) {
				if (q.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(q.poll()[1] + "\n");
			} else
				q.add(new int[] { Math.abs(ins), ins });
		}

		System.out.print(sb);
	}

}