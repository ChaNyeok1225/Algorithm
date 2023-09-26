import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		int[] arr = new int[n];
		int[] index = new int[n];
		int[] res = new int[n];
		
		int l = 0, r = 0, mid = 0, idx = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
			
		for(int i = 0; i < n; i++) {
			
			l = 0;
			r = idx;
			
			while(l < r) {
				mid = l + (r-l) /2;
				
				if(arr[mid] >= nums[i])
					r = mid;
				else
					l = mid + 1;
			}
			arr[r] = nums[i];
			index[r] = i;
			
			if(r == 0)
				res[i] = -1;
			else {
				res[i] = index[r-1];
			}
			
			
			if(idx < r+1) {
				idx = r+1;
			}
		}
		int[] print = new int[idx];
		
		int p = index[idx-1];
		for(int i = 0; i < idx; i++) {
			print[i] = nums[p];
			p = res[p];
		}
		
		System.out.println(idx);
		
		for(int i = idx-1; i >= 0; i--)
			sb.append(print[i]).append(" ");
		System.out.println(sb);
		
	}

}