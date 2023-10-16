import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Integer[] num = new Integer[n];
		
		for(int i = 0 ; i < n ;i++)
			num[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(num, Collections.reverseOrder());
		
		for(int i = 0; i < n; i++)
			sb.append(num[i]).append("\n");
		System.out.print(sb);
		
	}
	
}