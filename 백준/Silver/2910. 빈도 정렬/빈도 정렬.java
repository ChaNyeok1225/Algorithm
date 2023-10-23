import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		HashMap<Integer, Integer> map = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		int[][] arr = new int[map.size()][2];

		int cnt = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			arr[cnt][0] = entry.getKey();
			arr[cnt][1] = entry.getValue();
			cnt++;
		}

		Arrays.sort(arr, (a, b) -> b[1] - a[1]);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i][1]; j++)
				sb.append(arr[i][0]).append(" ");
		}

		System.out.println(sb);
	}

}