import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		
		int n = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[n+1];
		ArrayList<Integer> prime = new ArrayList<>();
		
		for(int i = 2; i * i <= n; i++) {
			if(isPrime[i]) continue;
			
			for(int j = i * i; j <= n; j += i) {
				isPrime[j] = true;
			}

		}
		
		for(int i = 2; i <= n; i++)
			if(!isPrime[i]) prime.add(i);
		prime.add(0);
		
		
		int cnt = 0, en = 0;
		int sum = 2;
		for(int st = 0; st < prime.size() - 1; st++) {
			while(sum < n && en < prime.size() - 1) {
				sum += prime.get(++en);
			}
			
			if(sum == n)
				cnt++;
			
			sum -= prime.get(st);
		}
		
		System.out.println(cnt);
	}

}
