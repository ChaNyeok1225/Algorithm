import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int vic = -1, vicnum = -1;
		
		int[] nums = new int[5];
		
		for(int t = 1; t < n + 1; t++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < 5; m++)
				nums[m] = Integer.parseInt(st.nextToken());
			
			
			for(int i = 0; i < 3; i++) {
				for(int j = i+1; j < 4; j++) {
					for(int k = j + 1; k < 5; k++) {
						int num = (nums[i] + nums[j] + nums[k]) % 10;
						
						if(vicnum <= num) {
							vicnum = num;
							vic = t;
						}
					}
				}
			}
		}
		
		System.out.println(vic);
		
	}

}
