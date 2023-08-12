import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] nums = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		int eidx = 0, sum = nums[0];
		boolean flag = true;
		
		for(int sidx = 0; sidx < n; sidx++) {
			while(eidx < n && sum < s) {
				sum += nums[++eidx];
			}
			if(eidx == n)
				break;
			min = min > eidx - sidx + 1? eidx - sidx + 1 : min;
			sum -= nums[sidx];
		}
		
		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
		
	}

}
