import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int max = 1, num = 0;
		
		
		for(int i = 1; i <= n; i++) {
			int cnt = 2;
			int a = i, b = n - i;
			while(b >= 0) {
				cnt++;
				int tmp = b;
				b = a - b;
				a = tmp;
			}
			
			if(cnt > max) {
				max = cnt;
				num = i;
			}
			
		}
		System.out.println(max);
		sb.append(n + " ");
		sb.append(num + " ");
		int nxt = n - num;
		while(nxt >= 0) {
			sb.append(nxt + " ");
			int tmp = nxt;
			nxt = num - nxt;
			num = tmp;
		}
		System.out.println(sb);
		
		
		
	}

}
