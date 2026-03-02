#include <iostream>

using namespace std;

constexpr int MAX_N = 500'000;

int N, M;
int arr[MAX_N + 1];
int tree[4 * MAX_N + 1];

void init(int node, int l, int r) {
	if (l == r) {
		tree[node] = arr[l];
		return;
	}

	int mid = (l + r) >> 1;
	
	init(node << 1, l, mid);
	init(node << 1 | 1, mid + 1, r);
	tree[node] = tree[node << 1] + tree[node << 1 | 1];
}

void update(int node, int l, int r, int index, int value) {
	//if (index < l || r < index)
	//	return;

	if (l == r) {
		tree[node] += value;
		return;
	}

	int mid = (l + r) >> 1;
	if (index <= mid)
		update(node << 1, l, mid, index, value);
	else 
		update(node << 1 | 1, mid + 1, r, index, value);
	
	tree[node] = tree[node << 1] + tree[node << 1 | 1];
}

int query(int node, int l, int r, int value) {
	if (l == r)
		return l;
	int mid = (l + r) >> 1;
	int lv = tree[node << 1];
	if (value <= lv)
		return query(node << 1, l, mid, value);
	else
		return query(node << 1 | 1, mid + 1, r, value - lv);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> arr[i];
	}

	init(1, 1, N);

	cin >> M;
	int op, a, b;
	for (int i = 0; i < M; ++i) {
		cin >> op;

		if (op == 1) {
			cin >> a >> b;
			update(1, 1, N, a, b);
		}
		else {
			cin >> a;
			cout << query(1, 1, N, a) << "\n";
		}
	}

	return 0;
}