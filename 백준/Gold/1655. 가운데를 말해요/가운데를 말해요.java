import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b-a);
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(maxheap.size() <= minheap.size())
				maxheap.offer(num);
			else
				minheap.offer(num);
			
			if(!minheap.isEmpty() && minheap.peek() < maxheap.peek()) {
				minheap.offer(maxheap.poll());
				maxheap.offer(minheap.poll());
			}
			
			sb.append(maxheap.peek() + "\n");
		}
		
		System.out.println(sb);
	}
}
