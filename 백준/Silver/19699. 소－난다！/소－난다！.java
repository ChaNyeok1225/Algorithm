import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[] prime = new boolean[9001];
	static boolean[] chk = new boolean[9001];
	static int[] w;
	static int n, m;
	
	public static void main(String[] args) throws IOException {

		prime[0] = prime[1] = true;
		for (int i = 2; i * i < 9001; i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < 9001; j += i)
				prime[j] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		w = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			w[i] = Integer.parseInt(st.nextToken());
		
		dfs(0,0,0);

		boolean flag = true;
		for(int i = 0; i < 9001; i++)
			if(chk[i]) {
				sb.append(i + " ");
				flag = false;
			}
		
		if(flag)
			System.out.println(-1);
		else
			System.out.println(sb);
		
	}

	private static void dfs(int cnt, int idx, int sum) {
		
		if(cnt == m) {
			if(!prime[sum])
				chk[sum] = true;
			return;
		}

		for(int i = idx; i < n; i++)
			dfs(cnt+1, i+1, sum + w[i]);
		
	}

}
