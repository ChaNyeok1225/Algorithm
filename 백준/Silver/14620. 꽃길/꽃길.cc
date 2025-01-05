#include <iostream>
using namespace std;

int N, lim;
int answer = 5000;
int map[11][11];
bool chk[11][11];
int dr[] = { 0, 0, 1, 0, -1 }, dc[] = {0, 1, 0 ,-1 ,0};

void DFS(int index, int cnt, int cost);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	lim = N * N;
	DFS(0, 0, 0);

	cout << answer;
}

void DFS(int index, int cnt, int cost) {
	if (index >= lim || answer <= cost)
		return;

	if (cnt == 3) {
		answer = cost;
		return;
	}
	
	bool emptyFlag = true;
	int nr, nc;
	for (int d = 0; d < 5; d++) {
		nr = (index / N) + dr[d];
		nc = (index % N) + dc[d];

		if (nr < 0 || nr >= N || nc < 0 || nc >= N || chk[nr][nc]) {
			emptyFlag = false;
			break;
		}
	}

	DFS(index + 1, cnt, cost);

	if (emptyFlag) {
		for (int d = 0; d < 5; d++) {
			nr = (index / N) + dr[d];
			nc = (index % N) + dc[d];

			chk[nr][nc] = true;
			cost += map[nr][nc];
		}

		DFS(index + 1, cnt + 1, cost);

		for (int d = 0; d < 5; d++) {
			nr = (index / N) + dr[d];
			nc = (index % N) + dc[d];

			chk[nr][nc] = false;
		}
	}
}