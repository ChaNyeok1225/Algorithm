import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		long[][] D = new long[n+1][2];
		D[1] = new long[] {0,1};
		
		for(int i = 2; i < n + 1; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		
		System.out.println(D[n][0] + D[n][1]);
	}
    // 틀렸던 이유
    // 아웃풋의 범위 체크

}
