import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		double[] nums = new double[n];
		
		for(int i = 0; i < n; i++)
			nums[i] = Double.parseDouble(br.readLine());
		
		double mul = 0;
		double max = 0;
		for(int i = 0; i < n; i++) {
			if(mul < 1)
				mul = nums[i];
			else
				mul *= nums[i];
			
			if(mul > max)
				max = mul;
		}
		
		System.out.printf("%.3f",max);
		
	}

}
