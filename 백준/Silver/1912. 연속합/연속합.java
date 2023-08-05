import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int max = -1000;
		int sum = 0;
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(st.nextToken());
			if(max < sum)
				max = sum;
			if(sum < 0)
				sum = 0;
		}
		
		System.out.println(max);
	}

}
