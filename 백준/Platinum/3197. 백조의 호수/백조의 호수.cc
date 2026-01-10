#include <stdio.h>

int R, C;
char map[1505][1505];
int p[1505][1505];

int dr[] = { 1, 0, -1, 0 }, dc[] = { 0, 1, 0, -1 };

struct Data {
	int r;
	int c;
} que[2][2250000];

int head[2] = { 0, }, tail[2] = { 0, };

int swan[2];

int Find(int a) {
	int row = a / C;
	int col = a % C;
	if (p[row][col] == a) return a;
	return p[row][col] = Find(p[row][col]);
}

void Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	if (a == b)
		return;

	p[b / C][b % C] = a;
}

void BFS(int idx) {
	int nr, nc;

	int aidx = idx ^ 1;
	while (head[idx] != tail[idx]) {
		Data d = que[idx][head[idx]++];
		int number = d.r * C + d.c;
		map[d.r][d.c] = '.';

		for (int dir = 0; dir < 4; dir++) {
			nr = d.r + dr[dir];
			nc = d.c + dc[dir];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			
			if (map[nr][nc] == 'X') {
				que[aidx][tail[aidx]++] = {nr, nc};
				map[nr][nc] = 'N';
				continue;
			}
			else if (map[nr][nc] == '.') {
				Union(number, nr * C + nc);
			}

		}
	}
}

int main() {
	int si = 0;
	int pi = 0;
	int qi = 0;

	scanf("%d %d", &R, &C);
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			scanf(" %c", &map[i][j]);
			if (map[i][j] == 'L') {
				map[i][j] = '.';
				swan[si++] = pi;
			}
			if (map[i][j] != 'X') {
				que[qi][tail[qi]++] = { i , j };
			}
			p[i][j] = pi++;
		}
	}

	int day = 0;
	while (true) {
		
		BFS(qi);
		qi ^= 1;

		if (Find(swan[0]) == Find(swan[1])) {
			printf("%d", day);
			break;
		}
		day++;
	}

	return 0;
}