#include <stdio.h>

constexpr int SZ = 100;
constexpr int QS = (1 << 16);
int dr[] = { 1,0,-1,0 }, dc[] = { 0,1,0,-1 };

int W, H;
int pos[2][2];
char map[SZ + 5][SZ + 5];
int vis[SZ + 5][SZ + 5];

struct Data {
	int r;
	int c;
	int cnt;
	int dir;
};

struct PQ {
	Data arr[QS];
	int size = 0;

	bool comp(Data a, Data b) {
		return a.cnt < b.cnt;
	}

	Data top() {
		return arr[1];
	}
	
	void offer(Data val) {
		int c = ++size;
		int p = c >> 1;
		while (p) {
			if (comp(arr[p], val))
				break;
			arr[c] = arr[p];
			c = p;
			p >>= 1;
		}
		arr[c] = val;
	}

	void poll() {
		Data val = arr[size--];
		int p = 1;
		int c = p << 1;
		while (c <= size) {
			if (c + 1 <= size && comp(arr[c + 1], arr[c]))
				c++;
			if (comp(val, arr[c]))
				break;
			arr[p] = arr[c];
			p = c;
			c <<= 1;
		}
		arr[p] = val;
	}
} pq;

bool OOR(int r, int c) {
	return r < 0 || r >= H || c < 0 || c >= W;
}

int main() {
	int pidx = 0;

	scanf("%d%d", &W, &H);
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			scanf(" %c", &map[i][j]);
			if (map[i][j] == 'C') {
				map[i][j] = '.';
				pos[pidx][0] = i;
				pos[pidx][1] = j;
				pidx++;
			}
		}
	}

	pq.offer({ pos[0][0], pos[0][1], -1, -1 });

	Data cur;
	int dir, nr, nc, ncnt, ndir;
	while (pq.size) {
		cur = pq.top(); pq.poll();

		if (vis[cur.r][cur.c] & (1 << cur.dir))
			continue;
		vis[cur.r][cur.c] |= (1 << cur.dir);

		if (cur.r == pos[1][0] && cur.c == pos[1][1]) {
			printf("%d", cur.cnt);
			break;
		}

		for (dir = 0; dir < 4; dir++) {
			nr = cur.r + dr[dir];
			nc = cur.c + dc[dir];
			ncnt = cur.dir == dir ? cur.cnt : cur.cnt + 1;

			if (OOR(nr, nc))
				continue;
			if (map[nr][nc] == '*')
				continue;
			if (vis[nr][nc] & (1 << dir))
				continue;

			pq.offer({ nr, nc, ncnt, dir });
		}
	}

	return 0;
}