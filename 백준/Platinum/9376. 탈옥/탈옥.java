import java.io.*;
import java.util.*;

public class Main {

	static char[][] board;
	static int h, w, crim[][], area[][], no, doorNo;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static List<Integer>[] dList;
	static boolean[] isDoor;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			crim = new int[2][2];
			int idx = 0;

			board = new char[h + 2][w + 2];
			area = new int[h + 2][w + 2];
			doorNo = 0;

			Arrays.fill(board[0], '.');
			Arrays.fill(board[h + 1], '.');

			for (int i = 1; i < h + 1; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 1; j < w + 1; j++) {
					board[i][j] = c[j - 1];

					if (board[i][j] == '$') {
						crim[idx][0] = i;
						crim[idx++][1] = j;
						board[i][j] = '.';
					}
				}
				board[i][0] = '.';
				board[i][w + 1] = '.';
			}

			fill();

			isDoor = new boolean[no];
			dList = new ArrayList[no];
			for (int i = 0; i < no; i++)
				dList[i] = new ArrayList<Integer>();

			setDoor();

			int a = area[crim[0][0]][crim[0][1]];
			int b = area[crim[1][0]][crim[1][1]];
			
			int[] disA = search(a);
			int[] disB = search(b);
			int[] disS = search(1);
			
			int ans = Integer.MAX_VALUE;
			
			ans = ans < disA[1] + disB[1] ? ans : disA[1] + disB[1];
			ans = ans < disA[b] + disB[1] ? ans : disA[b] + disB[1];
			ans = ans < disA[1] + disB[a] ? ans : disA[1] + disB[a];
			for(int i = 1; i < no; i++) {
				int val = 0;
				if(isDoor[i])
					val = 2;
				ans = ans < disS[i] + disA[i] + disB[i] - val? ans : disS[i] + disA[i] + disB[i] - val;
			}
			
			System.out.println(ans);
		}
	}

	static int[] search(int ...start ) {
		int[] dist = new int[no];
		Arrays.fill(dist, 10000);
		PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1] );
		for(int s : start) {
			dist[s] = 0;
			pq.offer(new int[] {s, dist[s]});
		}
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			for(int nxt : dList[cur[0]]) {
				int val = 0;
				if(!isDoor[nxt]) 
					val = cur[1];
				else 
					val = cur[1] + 1;
				
				if(dist[nxt] <= val)
					continue;
				
				dist[nxt] = val;
				pq.offer(new int[] {nxt, val});
				
			}
		}
		
		return dist;
	}
	
	static void setDoor() {
		for (int i = 1; i < h + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (board[i][j] != '#')
					continue;
				isDoor[area[i][j]] = true;

				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];

					if (valid(nx, ny))
						continue;

					else if (area[nx][ny] != 0) {
						if (board[nx][ny] != '#')
							dList[area[nx][ny]].add(area[i][j]);
						dList[area[i][j]].add(area[nx][ny]);
					}
				}
			}
		}
	}

	static void fill() {
		no = 1;
		Queue<int[]> q = new ArrayDeque<int[]>();
		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				if (area[i][j] == 0 && board[i][j] == '#')
					area[i][j] = no++;
				else if (area[i][j] == 0 && board[i][j] == '.') {
					area[i][j] = no++;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];

							if (valid(nx, ny) || board[nx][ny] != '.' || area[nx][ny] != 0)
								continue;

							area[nx][ny] = area[cur[0]][cur[1]];
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
	}

	static boolean valid(int x, int y) {
		return x < 0 || x >= h + 2 || y < 0 || y >= w + 2;
	}

}