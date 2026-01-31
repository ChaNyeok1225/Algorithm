#include <stdio.h>

using ll = long long;
constexpr int SZ = 1'000'000;
constexpr int MOD = 1'000'000'007;

int N, M, K;
int arr[SZ + 5];
ll tree[4 * SZ + 5];

void init(int node, int l, int r) {
	if (l == r) {
		tree[node] = arr[l];
		return;
	}
	int mid = (l + r) >> 1;
	init(node * 2, l, mid);
	init(node * 2 + 1, mid + 1, r);

	tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
}

void update(int node, int l, int r, int index, int value) {
	if (index < l || r < index)
		return;

	if (l == r) {
		tree[node] = value;
		return;
	}
	int mid = (l + r) >> 1;
	update(node * 2, l, mid, index, value);
	update(node * 2 + 1, mid + 1, r, index, value);

	tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
}

ll query(int node, int l, int r, int s, int e) {
	if (r < s || e < l)
		return 1;

	if (s <= l && r <= e) {
		return tree[node];
	}

	int mid = (l + r) >> 1;
	ll lv = query(node * 2, l, mid, s, e);
	ll rv = query(node * 2 + 1, mid + 1, r, s, e);

	return (lv * rv) % MOD;
}

int main() {
	scanf("%d%d%d", &N, &M, &K);
	for (int i = 1; i < N + 1; ++i) {
		scanf("%d", &arr[i]);
	}
	init(1, 1, N);

	int T = M + K;
	int a, b, c;
	while (T--) {
		scanf("%d%d%d", &a, &b, &c);

		if (a == 1)
			update(1, 1, N, b, c);
		else
			printf("%lld\n", query(1, 1, N, b, c));
	}
}