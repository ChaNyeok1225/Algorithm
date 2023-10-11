import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long f[] = new long[1000001];
	
	public static void main(String[] args) throws IOException {
			
		int T = Integer.parseInt(br.readLine());
		long mod = 1234567891;
		
		f[0] = f[1] = 1;
		for(int i = 2; i < 1000001; i++) {
			f[i] = (f[i-1] * i) % mod;
		}
		
		for(int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			long ans = nCr(n, r, mod);
			
			
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		
		System.out.print(sb);
		
	}
	
	static long nCr(int n, int r, long mod) {
		if(r==0)
			return 1;
		
		return (f[n] * power(f[r], mod-2, mod)%mod * power(f[n-r], mod-2, mod)%mod)% mod;
	}
	
	static long power(long a, long b, long mod) {
		long res = 1;
		
		while(b > 0) {
			if(b % 2 == 1)
				res = (res*a) % mod;
			a = (a * a) % mod;
			b = b >> 1;
		}
		return res;
	}
	
}