#include <iostream>
#include <queue>
using namespace std;

int R, C;
char map[251][251];
bool vis[251][251];
int dr[] = { 1,0,-1,0 }, dc[] = { 0,1,0,-1 };


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
		}
	}

	int answerO = 0, answerV = 0;

	queue<pair<int, int>> q;
	pair<int, int> cur;
	int o, v, nr, nc;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (vis[i][j] || map[i][j] == '#') continue;

			q.push(make_pair(i, j));
			vis[i][j] = true;
			o = v = 0;

			while (!q.empty()) {
				cur = q.front();
				q.pop();

				if (map[cur.first][cur.second] == 'o')
					o++;
				else if (map[cur.first][cur.second] == 'v')
					v++;

				for (int d = 0; d < 4; d++) {
					nr = cur.first + dr[d];
					nc = cur.second + dc[d];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C || vis[nr][nc] || map[nr][nc] == '#')
						continue;

					q.push(make_pair(nr, nc));
					vis[nr][nc] = true;
				}
			}

			if (v >= o) {
				answerV += v;
			}
			else {
				answerO += o;
			}
		}
	}

	cout << answerO << ' ' << answerV;


}