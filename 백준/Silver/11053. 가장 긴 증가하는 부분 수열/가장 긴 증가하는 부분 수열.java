import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		int[] D = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
            
            // 틀렸던 이유, D[i]을 1로 초기화 안함
			D[i] = 1;
		}
		
		int max = 1;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					D[i] = Math.max(D[j] + 1, D[i]);
					if(max < D[i])
						max = D[i];
				}
				
			}
			
		}
		System.out.println(max);
	}

}
