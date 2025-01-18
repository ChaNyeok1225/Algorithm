#include <iostream>
#include <queue>
using namespace std;

struct Pos { int r;  int c; };

char map[1505][1505];
int area[1505][1505];
int r, c;

queue<Pos> q[2];

int Find(int a) {
	int row = a / c;
	int col = a % c;

	if (a == area[row][col]) return a;
	return area[row][col] = Find(area[row][col]);
}

void Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	area[a / c][a % c] = b;
}

bool OOR(int row, int col) {
	return row < 0 || row >= r || col < 0 || col >= c;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	bool seq = 0;
	int L[2] = {};
	cin >> r >> c;

	int label = 0;
	int index = 0;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];
			if (map[i][j] != 'X') {
				q[seq].push({ i ,j });
			}
			if (map[i][j] == 'L') {
				L[index++] = label;
				map[i][j] = '.';
			}
			area[i][j] = label++;
		}
	}

	int dr[] = { 1, 0, -1, 0 }, dc[] = { 0, 1, 0, -1 };

	int day = 0;
	int number;
	while (true) {

		while (!q[seq].empty()) {
			Pos p = q[seq].front(); q[seq].pop();
			number = p.r * c + p.c;
			map[p.r][p.c] = '.';

			for (int d = 0; d < 4; ++d) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (OOR(nr, nc))
					continue;

				if (map[nr][nc] == 'X') {
					q[!seq].push({ nr, nc });
					map[nr][nc] = 'N';
				}
				else if(map[nr][nc] == '.') {
					Union(number, nr * c + nc);
				}
			}
		}

		seq = !seq;
		if (Find(L[0]) == Find(L[1]))
			break;
		day++;
	}

	cout << day;
}