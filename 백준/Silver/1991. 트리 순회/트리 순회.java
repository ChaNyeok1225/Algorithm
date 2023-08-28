import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] tree;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		tree = new int[n+1][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			char p = st.nextToken().charAt(0);
			char lc = st.nextToken().charAt(0);
			char rc = st.nextToken().charAt(0);
			if (lc != '.')
				tree[p - 'A' + 1][0] = lc - 'A' + 1;
			if (rc != '.')
				tree[p - 'A' + 1][1] = rc - 'A' + 1;
		}
		
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);

		System.out.println(sb);
		
	}

	private static void preorder(int v) {
		sb.append((char)(v+'A'-1));
		if(tree[v][0] != 0)
			preorder(tree[v][0]);
		if(tree[v][1] != 0)
			preorder(tree[v][1]);
	}
	private static void inorder(int v) {
		if(tree[v][0] != 0)
			inorder(tree[v][0]);
		sb.append((char)(v+'A'-1));
		if(tree[v][1] != 0)
			inorder(tree[v][1]);
	}
	private static void postorder(int v) {
		if(tree[v][0] != 0)
			postorder(tree[v][0]);
		if(tree[v][1] != 0)
			postorder(tree[v][1]);
		sb.append((char)(v+'A'-1));
	}

}
