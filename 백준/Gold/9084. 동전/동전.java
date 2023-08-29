import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			int[] val = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				val[i] = Integer.parseInt(st.nextToken());
			
			int m = Integer.parseInt(br.readLine());
			int[] D = new int[m+1];
			D[0] = 1;
			
			for(int i = 0; i < n; i++) {
				for(int j = val[i]; j < m + 1; j++)
					D[j] += D[j - val[i]];
			}
			
			sb.append(D[m]+"\n");
		}
		System.out.println(sb);
	}
}
