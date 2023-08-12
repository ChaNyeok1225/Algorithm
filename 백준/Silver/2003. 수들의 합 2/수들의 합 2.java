import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0, en = 0;
		int sum = nums[0];
		for(int st = 0; st < n; st++) {
			while(sum < m && en < n) {
				sum += nums[++en];
			}
			
			if(sum == m)
				cnt++;
			
			sum -= nums[st];
		}
		
		System.out.println(cnt);
	}

}
