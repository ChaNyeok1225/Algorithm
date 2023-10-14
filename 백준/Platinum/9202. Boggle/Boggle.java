import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static class Trie {
		Trie[] nxt = new Trie[26];
		boolean flag;
	}

	static int ans, cnt, max;
	static String str;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 }, dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static char[][] board;
	static boolean[][] vis;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {

		int w = Integer.parseInt(br.readLine());

		Trie root = new Trie();

		for (int i = 0; i < w; i++) {
			char[] c = br.readLine().toCharArray();

			Trie trie = root;
			for (int j = 0; j < c.length; j++) {
				if (trie.nxt[c[j] - 'A'] == null)
					trie.nxt[c[j] - 'A'] = new Trie();
				trie = trie.nxt[c[j] - 'A'];
			}
			trie.flag = true;
		}
		br.readLine();

		int n = Integer.parseInt(br.readLine());
		board = new char[4][];
		vis = new boolean[4][4];
		for (int t = 0; t < n; t++) {
			
			
			ans = cnt = max = 0;
			str = "";
			set = new HashSet<>();
			for (int i = 0; i < 4; i++)
				board[i] = br.readLine().toCharArray();

			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(root.nxt[board[i][j]-'A'] != null) {
						vis[i][j] = true;
						search(i,j, root.nxt[board[i][j]-'A'], 1, "" + board[i][j]);
						vis[i][j] = false;
					}
				}
			}
			
			sb.append(ans).append(" ");
			if(!str.equals(""))
				sb.append(str).append(" ");
			sb.append(cnt).append("\n");
			
			if(t==n-1) break;
			br.readLine();
		}

		System.out.print(sb);
	}
	
	static int score[] = {0,0,0,1,1,2,3,5,11};
	
	static void search(int x, int y, Trie trie, int len, String word) {
		
		if(!set.contains(word) && trie.flag) {
			set.add(word);
			
			cnt++;
			int val = score[len];
			
			if(len > max) {
				max = len;
				str = word;
			}
			if(len == max) {
				if(str.compareTo(word) > 0)
					str = word;
			}
			
			ans += val;
		}
		
		for(int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(valid(nx, ny)) continue;
			if(vis[nx][ny]) continue;
			if(trie.nxt[board[nx][ny]-'A'] != null ) {
				vis[nx][ny] = true;
				search(nx,ny, trie.nxt[board[nx][ny]-'A'], len+1, word + board[nx][ny]);
				vis[nx][ny] = false;
			}
		}
		
		
	}

	static boolean valid(int x, int y) {
		return x < 0|| 4 <= x || y < 0 || 4 <= y;
	}
	
}