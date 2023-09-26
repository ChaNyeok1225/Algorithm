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
		
		int[] arr = new int[n+1];
		
		int l = 0, r = 0, mid = 0, max = 0, idx = 0;
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			l = 0;
			r = idx;
			
			while(l < r) {
				mid = l + (r-l) /2;
				
				if(arr[mid] >= v)
					r = mid;
				else
					l = mid + 1;
			}
			arr[r] = v;
			if(idx < r+1)
				idx = r+1;
		}
		
		System.out.println(idx);
		
	}

}