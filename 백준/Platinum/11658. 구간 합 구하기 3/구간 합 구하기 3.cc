#include <iostream>

using namespace std;
using ll = long long;

constexpr int MAX_N = 1'024;

int N, M;
int arr[MAX_N + 1][MAX_N + 1];
int tree[MAX_N + 1][MAX_N + 1];

void update(int r, int c, int v) {
	for (int i = r; i <= N; i += (i & -i)) {
		for (int j = c; j <= N; j += (j & -j)) {
			tree[i][j] += v;
		}
	}
}

ll sum(int r, int c) {
	ll ret = 0;
	for (int i = r; i > 0; i -= (i & -i)) {
		for (int j = c; j > 0; j -= (j & -j)) {
			ret += tree[i][j];
		}
	}
	return ret;
}

ll query(int r1, int c1, int r2, int c2) {
	return sum(r2, c2)
		- sum(r2, c1 - 1)
		- sum(r1 - 1, c2)
		+ sum(r1 - 1, c1 - 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			cin >> arr[i][j];
			update(i, j, arr[i][j]);
		}
	}

	int op, a, b, c, d;
	for (int i = 0; i < M; ++i) {
		cin >> op;
		if (op == 0) {
			cin >> a >> b >> c;
			int diff = c - arr[a][b];
			arr[a][b] = c;
			update(a, b, diff);
		}
		else {
			cin >> a >> b >> c >> d;
			cout << query(a, b, c, d) << "\n";
		}
	}
	return 0;
}