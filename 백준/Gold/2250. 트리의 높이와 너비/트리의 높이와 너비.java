import java.io.*;
import java.util.*;

class Node {
	int n;
	int lc = 0;
	int rc = 0;
	int ln = 0;
	int rn = 0;
	int p = 0;

	public Node(int n) {
		super();
		this.n = n;
	}

	@Override
	public String toString() {
		return "Node [n=" + n + ", lc=" + lc + ", rc=" + rc + ", ln=" + ln + ", rn=" + rn + ", p=" + p + "]";
	}
}

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[][] board;
	static Node[] narr;
	static int md;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		narr = new Node[n + 1];
		int[] level = new int[n + 1];

		for (int i = 0; i < n + 1; i++)
			narr[i] = new Node(i);

		int c, np, cnt;
		int root = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int lc = Integer.parseInt(st.nextToken());
			int rc = Integer.parseInt(st.nextToken());

			narr[p].ln = lc;
			narr[p].rn = rc;

			cnt = 0;
			if (lc != -1) {
				narr[lc].p = p;
				narr[p].lc = 1;
			}
			if (rc != -1) {
				narr[rc].p = p;
				narr[p].rc = 1;
			}
		}

		for (int i = 1; i < n + 1; i++)
			if (narr[i].p == 0) {
				root = i;
				level[i] = 1;
				break;
			}

		dfs(root, 1);

//		for(int i = 1; i < n +1; i++)
//			System.out.println(narr[i]);

		board = new boolean[md + 1][n + 1];

		setBoard(root, 1, 1);

//		for (int i = 1; i < md + 1; i++)
//			System.out.println(Arrays.toString(board[i]));

		int maxdepth = 0, maxb = 0;
		int st = 0, en = 0;
		for (int i = 1; i < md + 1; i++) {
			int b = 0;
			for (int j = 1; j < n + 1; j++)
				if (board[i][j]) {
					st = j;
					break;
				}

			for (int j = n; j >= 0; j--)
				if (board[i][j]) {
					en = j;
					break;
				}

			b = en - st + 1;

			if (b > maxb) {
				maxb = b;
				maxdepth = i;
			}

		}
		System.out.println(maxdepth + " " + maxb);

	}

	private static int dfs(int number, int depth) {
		if(depth > md)
			md = depth;
		
		if (narr[number].ln != -1) 
			narr[number].lc = 1 + dfs(narr[number].ln, depth + 1);
		if (narr[number].rn != -1)
			narr[number].rc = 1 + dfs(narr[number].rn, depth + 1);
		return narr[number].lc + narr[number].rc;
	}

	private static void setBoard(int number, int st, int depth) {
//		System.out.println(number + " " + depth);

		board[depth][st + narr[number].lc] = true;

		if (narr[number].ln != -1) {
			setBoard(narr[number].ln, st, depth + 1);
		}

		if (narr[number].rn != -1) {
			setBoard(narr[number].rn, st + narr[number].lc + 1, depth + 1);
		}

	}

}
