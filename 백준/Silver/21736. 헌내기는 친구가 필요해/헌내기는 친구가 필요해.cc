#include <iostream>
#include <queue>
using namespace std;

int N, M;
int dr[] = { 1,0,-1,0 }, dc[] = { 0,1,0,-1 };
char map[601][601];
bool vis[601][601];
int answer;

void DFS(int r, int c);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	int r = 0, c = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'I') {
				r = i;
				c = j;
			}
		}
	}

	DFS(r, c);

	if (answer == 0) {
		cout << "TT";
	}
	else {
		cout << answer;
	}
}

void DFS(int r, int c) {

	vis[r][c] = true;
	if (map[r][c] == 'P')
		answer++;

	int nr, nc;
	for (int d = 0; d < 4; d++) {
		nr = r + dr[d];
		nc = c + dc[d];

		if (nr < 0 || nc < 0 || nr >= N || nc >= M || vis[nr][nc])
			continue;
		if (map[nr][nc] == 'X')
			continue;
		DFS(nr, nc);
	}

}