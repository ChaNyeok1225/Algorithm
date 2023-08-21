import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j  = 0; j < n; j++) 
				pq.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < n-1; i++)
			pq.poll();
		System.out.println(pq.poll());
		
	}
}
