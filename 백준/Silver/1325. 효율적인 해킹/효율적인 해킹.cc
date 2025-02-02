#include <iostream>
#include <queue>
#include <vector>
#include <bitset>
#include <algorithm>
using namespace std;

int N, M;
vector<int> conn[10001];
bitset<10001> vis[10001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	cin >> N >> M;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		conn[b].push_back(a);
	}

	queue<int> q;
	int maxCount = 0;

	for (int i = 1; i <= N; i++) {
		q.push(i);
		vis[i].set(i);

		while (!q.empty()) {
			int cur = q.front();
			q.pop();

			for (int next : conn[cur]) {
				if (vis[i][next]) continue;
				if (next < i)
					vis[i] |= vis[next];
				else {
					q.push(next);
					vis[i].set(next);
				}
			}
		}
		maxCount = max(maxCount, (int)vis[i].count());
	}
	vector<int> v;
	for (int i = 1; i <= N; i++) {
		int cnt = vis[i].count();
		if (cnt == maxCount)
			v.push_back(i);
	}

	for (int res : v) {
		cout << res << " ";
	}

}