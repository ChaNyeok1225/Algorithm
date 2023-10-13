import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		int len = numbers.length;

		long[][] snum = new long[len][2];

		for (int i = 0; i < len; i++) {
			String s = String.valueOf(numbers[i]);
			int idx = 0;

			while (s.length() < 10) {
				s += s.charAt(idx++);
			}
			snum[i][0] = Long.parseLong(s);
			snum[i][1] = i;
		}

		Arrays.sort(snum, (a, b) -> Long.compare(b[0],a[0]));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++)
			sb.append(numbers[(int)snum[i][1]]);

		String result = sb.toString();
		if (result.charAt(0) == '0')
			result = "0";
		
		System.out.println(result);
		
		
	}

}