import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] home = new int[n];
		for(int i = 0; i < n; i++)
			home[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(home);
		int start = 1, end = home[n-1] - home[0];
		int mid, ans = 0;
		
		
		while(start <= end) {
			mid = start + (end - start) / 2;
			
			int cnt = 1;
			int point = home[0];
			
			for(int i = 1; i < n; i++) {
				if(home[i] - point >= mid) {
					cnt++;
					point = home[i];
				}
			}
			
			if(cnt >= c) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
			
		}
		
		System.out.println(ans);
		
	}
}