import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] arr = new long[n];
		
		for(int i = 0; i < n; i++) {
			sb.setLength(0);
			sb.append(sc.nextLong());
			arr[i] = Long.parseLong(sb.reverse().toString());
		}
		
		Arrays.sort(arr);
		
		sb.setLength(0);
		for(int i = 0; i < n; i++)
			sb.append(arr[i]).append("\n");
		
		System.out.print(sb);
		
	}
	
}