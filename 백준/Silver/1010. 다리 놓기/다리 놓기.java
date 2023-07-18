import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dp = new int[31][31];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T + 1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			long res = comb(M, N);
			
			bw.write(String.valueOf(res) + "\n");
			
			bw.flush();
			
		}
		
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}

	static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r]= comb(n - 1, r - 1) + comb(n - 1, r);

    }
}
