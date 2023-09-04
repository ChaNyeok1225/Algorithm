import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] order = new int[k+1];
		Queue<Integer>[] q = new ArrayDeque[k+1];
		for(int i = 1; i < k + 1; i++)
			q[i] = new ArrayDeque<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			int v = Integer.parseInt(st.nextToken());
			order[i] = v;
			q[v].offer(i);
		}
		
		int[] cur = new int[n];
		int cnt = 0, res = 0, sel = 0, idx = 0;
		
		loop: for(int i = 0; i < k; i++) {
			int c = order[i];

			q[c].poll();
			
			for(int j = 0; j < n; j++) 
				if(cur[j] == c) {
					continue loop;
				}
			
			if(cnt < n) {
				cur[cnt++] = c;
			} else {
				sel = 0;
				for(int j = 0; j < n; j++) {
					if(q[cur[j]].isEmpty()) {
						idx = j;
						break;
					}
					
					if(q[cur[j]].peek() > sel ) {
						idx = j;
						sel = q[cur[j]].peek();
					}
				}
				
				cur[idx] = c;
				res++;
			}
		}
		
		System.out.println(res);
	}
}