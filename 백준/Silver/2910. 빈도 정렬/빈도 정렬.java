import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		HashMap<Integer,int[]> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			int val = Integer.parseInt(st.nextToken());
			int[] cur = map.getOrDefault(val, new int[] {0, i});
			cur[0]++;
			map.put(val, cur);
		}
			
		int[][] arr = new int[map.size()][3];
		
		int cnt = 0;
		for(Integer key : map.keySet()) {
			arr[cnt][0] = key;
			int[] tmp = map.get(key);
			arr[cnt][1] = tmp[0];
			arr[cnt][2] = tmp[1];
			cnt++;
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(b[1] == a[1])
				return a[2] - b[2];
			return b[1]-a[1];
		});
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i][1]; j++)
				sb.append(arr[i][0]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}