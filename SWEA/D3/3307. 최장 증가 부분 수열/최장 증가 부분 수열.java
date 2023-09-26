import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < t + 1; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int v = Integer.parseInt(st.nextToken());
				int r = Collections.binarySearch(list, v);

				if (r < 0) {
					if (-r > list.size())
						list.add(v);
					else
						list.set(-r - 1, v);
				}
			}
			System.out.printf("#%d %d\n",tc, list.size());
		}		
	}
	
}