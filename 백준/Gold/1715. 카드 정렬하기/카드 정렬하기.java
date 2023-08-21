import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++)
			pq.offer(Integer.parseInt(br.readLine()));

		int total = 0;
		while (pq.size() > 1) {
			int num = pq.poll() + pq.poll();
			total += num;
			pq.offer(num);
		}

		System.out.println(total);
	}
}
