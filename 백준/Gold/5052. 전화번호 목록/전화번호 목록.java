import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			String[] pn = new String[n];
			for(int i = 0; i < n; i++)
				pn[i] = br.readLine();
			
			Arrays.sort(pn);
			
			boolean pf = true;
			
			for(int i = 1; i < n; i++) {
				if(pn[i].startsWith(pn[i-1])) {
					pf = false;
					break;
				}
			}

			if(pf)
				sb.append("YES");
			else
				sb.append("NO");
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}