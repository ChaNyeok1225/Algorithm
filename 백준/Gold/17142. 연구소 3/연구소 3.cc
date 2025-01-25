#include <iostream>
#define MX 2505

using namespace std;

struct Pos { int r; int c; };

int n, m;
int totalCount, answer = MX;
int map[51][51];
bool visited[51][51];
int selectedVirus[10];
int virusCount;
Pos virusPos[10];

const int qs = 1 << 10;
const int qmask = qs - 1;
Pos q[qs];
int dr[] = { 1, 0, -1 ,0 }, dc[] = { 0, 1, 0, -1 };

bool OOB(int r, int c) {
	return r < 0 || r >= n || c < 0 || c >= n;
}

void BFS() {
	int l = 0, r = 0;
	int infCnt = virusCount;
	Pos p;

	for (int i = 0; i < m; i++) {
		p = virusPos[selectedVirus[i]];
		visited[p.r][p.c] = true;
		q[r++] = p;
	}

	int step = 0;
	int sz;
	while (r - l) {
		if (infCnt == totalCount) {
			answer = answer < step ? answer : step;
			return;
		}
		
		sz = (r - l) & qmask;
		for (int i = 0; i < sz; i++) {
			p = q[l++];
			l &= qmask;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (OOB(nr, nc))
					continue;
				if (visited[nr][nc] || map[nr][nc] == 1)
					continue;
				if (map[nr][nc] == 0)
					infCnt++;
				visited[nr][nc] = true;
				q[r++] = { nr, nc };
				r &= qmask;
			}
		}
		step++;
	}

	

}

void resetVisited() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visited[i][j] = false;
		}
	}
}

void Select(int cnt, int index) {
	if (cnt == m) {
		BFS();
		resetVisited();
		return;
	}

	for (int i = index; i < virusCount; i++) {
		selectedVirus[cnt] = i;
		Select(cnt + 1, i + 1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	int wallCnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			
			if (map[i][j] == 1) {
				wallCnt++;
			} else if (map[i][j] == 2) {
				virusPos[virusCount++] = { i, j };
			} 
		}
	}

	totalCount = (n * n) - wallCnt;
	Select(0, 0);

	if (answer == MX)
		answer = -1;
	cout << answer;

}