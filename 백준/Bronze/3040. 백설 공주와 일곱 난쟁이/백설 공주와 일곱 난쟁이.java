import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] arr;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {

		arr = new int[7];
		nums = new int[9];
		for(int i = 0; i < 9; i++)
			nums[i] = Integer.parseInt(br.readLine());

		func(0,0,0);

		System.out.print(sb);

	}

	private static void func(int sum, int r, int idx) {
		if (r == 7) {
			if (sum == 100) {
				for (int i = 0; i < r; i++)
					sb.append(arr[i] + "\n");
			}
			return;
		}
		for (int i = idx; i < 9; i++) {
			arr[r] = nums[i];
			func(sum + nums[i], r + 1, i + 1);
		}
	}

}