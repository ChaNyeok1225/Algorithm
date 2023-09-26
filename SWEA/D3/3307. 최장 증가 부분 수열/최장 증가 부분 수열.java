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
			
			L : for(int i = 0; i < n; i++) {
				int v = Integer.parseInt(st.nextToken());
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j) >= v) {
						list.set(j, v);
						continue L;
					}
				}
				list.add(v);
			}
			System.out.printf("#%d %d\n",tc, list.size());
		}		
	}
	
}