import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] arr;
	static int[] nums;
	static boolean[] vis;

	static int n;
	public static void main(String[] args) throws IOException {

		///////////////////// 구현부//////////////////////

		while(true) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			
			arr = new int[6];
			nums = new int[n];
			
			for(int i = 0; i < n; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			func(0, 0);
			sb.append("\n");
			
		}
		
		System.out.print(sb);
	}

	public static void func(int idx, int r) {
		if(r == 6) {
			for(int i = 0; i < 6; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < n; i++) {
			arr[r] = nums[i];
			func(i+1, r+1);
			
		}
		

	}
}
