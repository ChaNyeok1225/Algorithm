import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		for(int i = 1; i < n + 1; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int[] group = new int[n+1];
		
		int llen = 0;
		int lidx = 0;
		boolean[] sel = new boolean[n+1];
		
		
		for(int i = 1; i < n +1; i++) {
			if(group[i] != 0) continue;
			int nxt = arr[i];
			group[i] = i;
			
			while(group[nxt] == 0) {
				group[nxt] = i;
				nxt = arr[nxt];
			}

			while(group[nxt]==i) {
				group[nxt] = -1;
				sel[nxt] = true;
				nxt=arr[nxt];
			}
			
		}
		
		int cnt = 0;
		for(int i = 1; i < n + 1; i++) {
			if(sel[i]) {
				cnt++;
				sb.append(i+"\n");
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}

}
