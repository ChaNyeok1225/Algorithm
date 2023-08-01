import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	
	static int[] arr;
	static boolean[] vis;
	static int[] nums;
	
	
	public static void main(String[] args) throws IOException {

		///////////////////// 구현부//////////////////////
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		arr = new int[n];
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		func(0);
		
		System.out.println(sb);
		
	}

	public static void func(int k) {
		if(k == m) {
			for(int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		
		for(int i = 0; i < n; i++) {
			arr[k] = nums[i];
			func(k+1);
		}
		
	}
}
