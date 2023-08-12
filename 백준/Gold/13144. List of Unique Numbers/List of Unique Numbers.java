import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		boolean[] chk = new boolean[100001];
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		
		long cnt = 0;
		int en = 0;
		for(int st = 0; st < n; st++) {
			
			while(en < n && !chk[nums[en]]) {
				chk[nums[en++]] = true;
			}
			
			cnt += en - st;
			
			chk[nums[st]] = false;
		}
		
		
		System.out.println(cnt);
	}

}
