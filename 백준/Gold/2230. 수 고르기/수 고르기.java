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

		int[] nums = new int[n];

		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Arrays.sort(nums);

		int min = Integer.MAX_VALUE;

		int sidx = 0;
		int eidx = 1;
		
		while(eidx < n) {
			int v = nums[eidx] - nums[sidx];
			
			if(v == m) {
				min = v;
				break;
			}
			
			if(v >= m && min > v)
				min = v;
			
			if(v < m)
				eidx++;
			else
				sidx++;
			
		}
		
		System.out.println(min);
		
	}

}
