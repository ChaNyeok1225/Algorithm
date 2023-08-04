import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 4; i <= n; i++) {
				if(arr[i] != 0) continue;
				
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			
			sb.append(arr[n]+"\n");
			
		}
		
		System.out.println(sb);
		
	}

}
