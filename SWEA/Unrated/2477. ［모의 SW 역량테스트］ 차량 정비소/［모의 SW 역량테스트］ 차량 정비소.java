import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T +1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int frc = Integer.parseInt(st.nextToken());
			int frp = Integer.parseInt(st.nextToken());
			
			int[] recep = new int[n+1];
			int[] useRecep = new int[n+1];
			int[] rep = new int[m+1];
			int[] useRep = new int[m+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < n+1; i++)
				recep[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < m+1; i++)
				rep[i] = Integer.parseInt(st.nextToken());
			
			
			PriorityQueue<int[]> custq = new PriorityQueue<>((a,b) -> {
				if(a[1] == b[1] ) return a[0] - b[0];
				return a[1]-b[1];
			});
			PriorityQueue<int[]> recepq = new PriorityQueue<>((a,b) -> {
				if(a[2] == b[2]) return a[1]-b[1];
				return a[2]-b[2];
			});
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < k+1; i++)
				custq.offer(new int[] {i,Integer.parseInt(st.nextToken())});
			
			int sec = 0;
			int total = 0;
			while(true) {
				while(!custq.isEmpty() && sec >= custq.peek()[1]) {
					boolean flag = true;
					for(int i = 1; i < n + 1; i++) {
						if(useRecep[i] <= sec) {
							flag = false;
							int[] cust = custq.poll();
							useRecep[i] = sec + recep[i];
							recepq.offer(new int[] {cust[0], i, useRecep[i]});
							break;
						}
					}
					if(flag)
						break;
				}
				
				while(!recepq.isEmpty() && sec >= recepq.peek()[2]) {
					boolean flag = true;
					for(int i = 1; i < m + 1; i++) {
						if(useRep[i] <= sec) {
							flag = false;
							int[] cust = recepq.poll();
							useRep[i] = sec + rep[i];
							if(cust[1] == frc && i == frp)
								total += cust[0];
							break;
						}
					}
					if(flag)
						break;
				}
				if(custq.isEmpty() && recepq.isEmpty())
					break;
				sec++;
			}
			if(total == 0) total = -1;
			System.out.printf("#%d %d\n",tc, total);
		}
	}
}
