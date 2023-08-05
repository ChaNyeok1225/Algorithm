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
			D[i] = nums[i];
		}
		// 틀렸던 이유 int max = 0;
        // n이 1로 들어왔을 때, max 값을 바꿔주지 않기 때문에
        // max의 초기 값을 D[0]으로 설정
		int max = D[0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					D[i] = Math.max(D[j] + nums[i], D[i]);
					if(max < D[i])
						max = D[i];
				}
			}
		}
		
		System.out.println(max);
		
	}

}
