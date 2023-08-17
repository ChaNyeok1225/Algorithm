import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int k, max;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());

		int[][] cuts = new int[k][2];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			cuts[i][0] = Integer.parseInt(st.nextToken());
			cuts[i][1] = Integer.parseInt(st.nextToken());
		}

		cut(0, 0, m, n, 0, cuts);

		System.out.println(max);
	}

	private static void cut(int sx, int sy, int ex, int ey, int idx, int[][] cuts) {
		if(idx == k) {
			
			int area = (ex-sx) * (ey-sy);
			if(max < area)
				max = area;
			
			return;
		}
		
		
		int[] cut = cuts[idx];
		switch (cut[0]) {
		case 0:
			if (sx < cut[1] && cut[1] < ex) {
				cut(sx, sy, cut[1], ey, idx + 1, cuts);
				cut(cut[1], sy, ex, ey, idx + 1, cuts);
			} else
				cut(sx,sy,ex,ey,idx+1,cuts);
			break;

		case 1:

			if(sy < cut[1] && cut[1] < ey) {
			cut(sx, sy, ex, cut[1], idx + 1, cuts);
			cut(sx, cut[1], ex, ey, idx + 1, cuts);
			} else
				cut(sx,sy,ex,ey,idx+1,cuts);
			break;

		}

	}
}
