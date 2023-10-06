import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[n][2];
		for(int i = 0; i < n; i++) {
			nums[i][0] = Integer.parseInt(br.readLine());
			nums[i][1] = i;
		}
		
		Arrays.sort(nums, (a,b) -> a[0]-b[0]  );
		
		int ans = 0;
		for(int i = 0; i < n; i++) 
			ans = ans > nums[i][1]-i ? ans: nums[i][1]-i;
		
		System.out.println(++ans);
		
	}
	
}