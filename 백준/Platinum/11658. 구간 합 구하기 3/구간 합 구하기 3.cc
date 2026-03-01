#include <iostream>

using namespace std;
using ll = long long;

constexpr int MAX_N = 1'024;
constexpr int MAX_M = 100'000;

int N, M;
int arr[MAX_N + 10][MAX_N + 10];
ll tree[4 * MAX_N + 10][4 * MAX_N + 10];

void initCol(int nr, int sr, int er,
	int nc, int sc, int ec) {
	if (sc == ec) {
		if (sr == er) {
			tree[nr][nc] = arr[sr][sc];
		}
		else {
			tree[nr][nc] = tree[nr << 1][nc] + tree[nr << 1 | 1][nc];
		}
		return;
	}

	int mc = (sc + ec) >> 1;
	initCol(nr, sr, er, nc << 1, sc, mc);
	initCol(nr, sr, er, nc << 1 | 1, mc + 1, ec);

	tree[nr][nc] = tree[nr][nc << 1] + tree[nr][nc << 1 | 1];
}

void initRow(int nr, int sr, int er) {
	if (sr != er) {
		int mr = (sr + er) >> 1;
		initRow(nr << 1, sr, mr);
		initRow(nr << 1 | 1, mr + 1, er);
	}
	initCol(nr, sr, er, 1, 1, N);
}

ll queryCol(int nr, int nc, int sc, int ec, int c1, int c2) {
	if (c2 < sc || ec < c1) 
		return 0;
	if (c1 <= sc && ec <= c2)
		return tree[nr][nc];

	int mc = (sc + ec) >> 1;
	return queryCol(nr, nc << 1, sc, mc, c1, c2)
		+ queryCol(nr, nc << 1 | 1, mc + 1, ec, c1, c2);
}

ll queryRow(int nr, int sr, int er, int r1, int r2, int c1, int c2) {
	if (r2 < sr || er < r1)
		return 0;
	if (r1 <= sr && er <= r2)
		return queryCol(nr, 1, 1, N, c1, c2);

	int mr = (sr + er) >> 1;
	return queryRow(nr << 1, sr, mr, r1, r2, c1, c2)
		+ queryRow(nr << 1 | 1, mr + 1, er, r1, r2, c1, c2);
}

void updateCol(int nr, int sr, int er, int nc, int sc, int ec, int c, int value) {
	if (sc == ec) {
		if (sr == er)
			tree[nr][nc] = value;
		else
			tree[nr][nc] = tree[nr << 1][nc] + tree[nr << 1 | 1][nc];
		return;
	}

	int mc = (sc + ec) >> 1;
	if (c <= mc)
		updateCol(nr, sr, er, nc << 1, sc, mc, c, value);
	else
		updateCol(nr, sr, er, nc << 1 | 1, mc + 1, ec, c, value);
	tree[nr][nc] = tree[nr][nc << 1] + tree[nr][nc << 1 | 1];
}

void updateRow(int nr, int sr, int er, int r, int c, int value) {
	if (sr == er) {
		updateCol(nr, sr, er, 1, 1, N, c, value);
		return;
	}

	int mr = (sr + er) >> 1;
	if(r <= mr) 
		updateRow(nr << 1, sr, mr, r, c, value);
	else 
		updateRow(nr << 1 | 1, mr + 1, er, r, c, value);
	updateCol(nr, sr, er, 1, 1, N, c, value);
}

void init() {
	initRow(1, 1, N);
}

void update(int r, int c, int value) {
	updateRow(1, 1, N, r, c, value);
}

ll query(int r1, int c1, int r2, int c2) {
	return queryRow(1, 1, N, r1, r2, c1, c2);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			cin >> arr[i][j];
		}
	}

	init();

	int op, a, b, c, d;
	for (int i = 0; i < M; ++i) {
		cin >> op;
		if (op == 0) {
			cin >> a >> b >> c;
			update(a, b, c);
		}
		else {
			cin >> a >> b >> c >> d;
			cout << query(a, b, c, d) << "\n";
		}
	}

	return 0;
}