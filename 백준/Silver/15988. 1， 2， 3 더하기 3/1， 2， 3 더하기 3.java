import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		long[] D = new long[1_000_005];
		
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i = 4; i < 1_000_001 + 1; i++) {
			D[i] = (D[i-1] + D[i-2] + D[i-3]) % 1_000_000_009;
		}
		
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(D[n]+"\n");
		}
		
		System.out.print(sb);
	}

}
