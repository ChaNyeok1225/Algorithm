import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[][] p = new int[n][2];

		int max = 0, midx = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p, (a, b) -> a[0] - b[0]);
		
		for(int i = 0; i < n; i++) {
			if(max <= p[i][1]) {
				max = p[i][1];
				midx = i;
			}
		}
		
		int total = 0, point = 0, h = 0;
		for(int i = 0; i <= midx; i++) {
			total += (p[i][0] - point) * h;
			point = p[i][0] + 1;
			if(h < p[i][1])
				h = p[i][1];
			total += h;
		}
		point = 1000; h = 0;
		for(int i = n-1; i >= midx; i--) {
			total += (point - p[i][0]) * h;
			point = p[i][0] - 1;
			if(h < p[i][1])
				h = p[i][1];
			total += h;
		}
		total -= max;
		
		System.out.println(total);
		
	}

}
