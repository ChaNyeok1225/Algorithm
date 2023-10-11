import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long f[] = new long[1000001]; // 팩토리얼 저장 변수
	
	public static void main(String[] args) throws IOException {
			
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수
		long mod = 1234567891; // modulo 연산 값
		
		f[0] = f[1] = 1;
		for(int i = 2; i < 1000001; i++) { // 팩토리얼 값 초기화
			f[i] = (f[i-1] * i) % mod;
		}
		
		for(int tc = 1; tc < T + 1; tc++) { // 테스트케이스 횟수만큼 반복
			st = new StringTokenizer(br.readLine()); // 입력
			int n = Integer.parseInt(st.nextToken()); // n
			int r = Integer.parseInt(st.nextToken()); // r
			
			long ans = nCr(n, r, mod); // 연산
			
			sb.append(String.format("#%d %d\n", tc, ans)); // 출력
		}
		
		System.out.print(sb);
		
	}
	
	static long nCr(int n, int r, long mod) { // nCr
		if(r==0 || r == n) // r이 0 또는 n 이면 1
			return 1;
		
		return (f[n] * power(f[r], mod-2, mod)%mod * power(f[n-r], mod-2, mod)%mod)% mod; // 페르마 정리
	}
	
	static long power(long a, long b, long mod) { // 거듭제곱 계산법
		long res = 1; // 1로 초기화
		
		while(b > 0) { // 제곱수가 0이 될때까지 반복
			if(b % 2 == 1) // 제곱수가 2로 나누어떨어지지 않으면 원래의 값을 곱해준다
				res = (res*a) % mod;
			a = (a * a) % mod; // a 제곱
			b = b >> 1; // 제곱수 감소
		}
		return res;
	}
	
}