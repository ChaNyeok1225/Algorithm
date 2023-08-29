
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> nums = new ArrayList<>();
		int[] D = new int[n+1];
		
		
		Arrays.fill(D, Integer.MAX_VALUE);
		for(int i = 1; i * i <= n + 1; i++) {
			nums.add(i*i);
			D[i*i] = 1;
		}
		
		for(int i=1; i < n + 1; i++) {
			
			for(int j = 0; j < nums.size(); j++) {
				if(nums.get(j) >= i) break;
				D[i] = Math.min(D[i], D[i-nums.get(j)] + 1);
				
			}
			
		}
		System.out.println(D[n]);
		
		
	}
}
