import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(((n+1)/2) + "\n");
			
			PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
			PriorityQueue<Integer> minheap = new PriorityQueue<>();

			int cnt = 0;
			
			for (int i = 1; i < n+1; i++) {
				if(i % 10 == 1)
					st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				
				if (maxheap.size() <= minheap.size())
					maxheap.offer(num);
				else
					minheap.offer(num);

				if (!minheap.isEmpty() && minheap.peek() < maxheap.peek()) {
					minheap.offer(maxheap.poll());
					maxheap.offer(minheap.poll());
				}
				if(i % 2 == 1) {
					if(i > 1 && i % 20 == 1)
						sb.append("\n");
					sb.append(maxheap.peek() + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
