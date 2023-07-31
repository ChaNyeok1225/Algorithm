import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static int[] nums;
	static int[] arr;
	static boolean[] vis;
	
	

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		vis = new boolean[n];
		arr = new int[m];
		
		func(0);

		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int cnt) {
//		System.out.println(Arrays.toString(vis));
		if (cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}	
		
		for(int i = 0; i < n; i++) {
			if(vis[i]) continue;
			vis[i] = true;
			arr[cnt] = nums[i];
			func(cnt+1);
			
			vis[i] = false;
		}
		
	}

}
