import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		boolean[] prime = new boolean[1000001];
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i * i <= 1000000; i++) {
			if(prime[i]) continue;
			for(int j = i * i; j <= 1000000; j += i)
				if(!prime[j])
					prime[j] = true;
		} prime[2] = true;
		
		L : while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0)
				break;
			
			for(int i = 3; i <= n/2; i+=2) {
				if(prime[i]) continue;
				if(!prime[n-i]) {
					sb.append(String.format("%d = %d + %d\n", n, i, n - i));
					continue L;
				}
			}
			sb.append("Goldbach's conjecture is wrong.\n");
		}
		
		System.out.println(sb);
		
	}

}