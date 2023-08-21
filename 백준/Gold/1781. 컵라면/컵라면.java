import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
	
		PriorityQueue<Integer>[] pq = new PriorityQueue[n+1];
		
		for(int i = 1; i < n +1; i++)
			pq[i] = new PriorityQueue<>((a,b) -> b - a);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int cuplamen = Integer.parseInt(st.nextToken());
			
			pq[deadline].offer(cuplamen);
		}
		
		
		int total = 0;
		
		PriorityQueue<Integer> allpq = new PriorityQueue<>((a,b) -> b-a);
		for(int i = n; i >= 1; i--) {
			for(int num : pq[i])
				allpq.offer(num);
			
			if(!allpq.isEmpty())
				total+= allpq.poll();
		}
		System.out.println(total);
		
	}
}
