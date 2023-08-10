import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		long[] num = new long[n];
		
		for(int i = 0; i < n; i++)
			num[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(num);
		
		long prev = num[0], res = num[0];
		int cnt = 1, maxcnt = 1;
		for(int i = 1; i < n; i++) {
			if(num[i] == prev) {
				cnt++;
			} else {
				prev = num[i];
				cnt = 1;
			}
			
			if(cnt > maxcnt) {
				maxcnt = cnt;
				res = num[i];
			}
		}
		
		System.out.println(res);
		
	}
	
}
