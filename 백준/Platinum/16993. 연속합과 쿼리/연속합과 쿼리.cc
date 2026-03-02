#include <iostream>

using namespace std;

constexpr int MAX_N = 100'000;
constexpr int INF = 1'000'000'009;

inline int MAX(int a, int b) {
	return a > b ? a : b;
}

int N, M;
int arr[MAX_N + 1];
struct Data {
	int sum;
	int totalmax;
	int leftmax;
	int rightmax;
} tree[4 * MAX_N + 1];

void init(int node, int l, int r) {
	if (l == r) {
		tree[node] = { arr[l], arr[l], arr[l], arr[l] };
		return;
	}

	int mid = (l + r) >> 1;
	init(node << 1, l, mid);
	init(node << 1 | 1, mid + 1, r);

	Data lc = tree[node << 1];
	Data rc = tree[node << 1 | 1];

	tree[node] = {
		lc.sum + rc.sum,
		MAX(MAX(lc.totalmax, rc.totalmax), lc.rightmax + rc.leftmax),
		MAX(lc.leftmax, lc.sum + rc.leftmax),
		MAX(rc.rightmax, lc.rightmax + rc.sum)
	};

}

Data query(int node, int l, int r, int li, int ri) {
	if (ri < l || r < li)
		return { 0, -INF, -INF, -INF };
	if (li <= l && r <= ri)
		return tree[node];

	int mid = (l + r) >> 1;
	Data lc = query(node << 1, l, mid, li, ri);
	Data rc = query(node << 1 | 1, mid + 1, r, li, ri);

	return {
		lc.sum + rc.sum,
		MAX(MAX(lc.totalmax, rc.totalmax), lc.rightmax + rc.leftmax),
		MAX(lc.leftmax, lc.sum + rc.leftmax),
		MAX(rc.rightmax, lc.rightmax + rc.sum)
	};
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> arr[i];
	}

	init(1, 1, N);

	cin >> M;
	int a, b;
	for (int i = 0; i < M; ++i) {
		cin >> a >> b;
		cout << query(1, 1, N, a, b).totalmax << "\n";
	}

}