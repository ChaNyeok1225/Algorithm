#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, R;
int visited[100'001];
vector<int> conn[100'001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	cin >> N >> M >> R;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		conn[a].push_back(b);
		conn[b].push_back(a);
	}


	queue<int> q;
	int seq = 0;
	
	q.push(R);
	visited[R] = ++seq;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		sort(conn[cur].begin(), conn[cur].end());

		for (int next : conn[cur]) {
			if (visited[next]) continue;
			q.push(next);
			visited[next] = ++seq;
		}
	}

	for (int i = 1; i <= N; i++) {
		cout << visited[i] << "\n";
	}
}