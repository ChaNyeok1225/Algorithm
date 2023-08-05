import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		
		int max = -1000;
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += nums[i];
			
			if(max < sum)
				max = sum;
			
			if(sum < 0)
				sum = 0;
			
		}
		
		System.out.println(max);
	}

}
