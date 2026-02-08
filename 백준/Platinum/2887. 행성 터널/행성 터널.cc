#include <stdio.h>

using ll = long long;

constexpr int MAX_N = 100'000;
constexpr int MAX_E = 300'000;

int N;
struct Pos {
	int x;
	int y;
	int z;
} planet[MAX_N];

struct Edge {
	int a;
	int b;
	ll weight;
} edges[MAX_E + 100];
int edges_w[MAX_E + 100];

int planet_x[MAX_N];
int planet_y[MAX_N];
int planet_z[MAX_N];
int tmp[MAX_E + 100];

inline ll ABS(int a) {
	return a > 0 ? a : -a;
}

inline ll MIN(int a, int b) {
	return a < b ? a : b;
}

inline bool compX(int a, int b) {
	return planet[a].x < planet[b].x;
}

inline bool compY(int a, int b) {
	return planet[a].y < planet[b].y;
}

inline bool compZ(int a, int b) {
	return planet[a].z < planet[b].z;
}

inline bool compW(int a, int b) {
	return edges[a].weight < edges[b].weight;
}

void merge(int arr[], int l, int mid, int r, bool (*comp)(int, int)) {
	int li = l;
	int ri = mid + 1;
	int ti = li;

	while (li <= mid && ri <= r) {
		if (comp(arr[li], arr[ri]))
			tmp[ti++] = arr[li++];
		else
			tmp[ti++] = arr[ri++];
	}

	while (li <= mid) {
		tmp[ti++] = arr[li++];
	}

	while (ri <= r) {
		tmp[ti++] = arr[ri++];
	}

	for (int i = l; i <= r; ++i) {
		arr[i] = tmp[i];
	}
}

ll calcDistance(int a, int b) {
	return MIN(MIN(ABS(planet[a].x - planet[b].x) 
		, ABS(planet[a].y - planet[b].y)), 
		+ ABS(planet[a].z - planet[b].z));
}

void mergeSort(int arr[], int l, int r, bool (*comp)(int, int)) {
	if (l >= r) {
		return;
	}

	int mid = (l + r) >> 1;
	mergeSort(arr, l, mid, comp);
	mergeSort(arr, mid + 1, r, comp);
	merge(arr, l, mid, r, comp);
}

int p[MAX_N];

int find(int a) {
	if (p[a] == a) return a;
	return p[a] = find(p[a]);
}

bool unite(int a, int b) {
	a = find(a);
	b = find(b);

	if (a == b)
		return false;
	p[b] = a;
	return true;
}

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int x, y, z;
		scanf("%d %d %d", &x, &y, &z);
		planet[i] = { x, y, z };
		planet_x[i] = planet_y[i] = planet_z[i] = i;
	}

	mergeSort(planet_x, 0, N - 1, compX);
	mergeSort(planet_y, 0, N - 1, compY);
	mergeSort(planet_z, 0, N - 1, compZ);

	int edgeCnt = 0;

	for (int i = 0; i < N; i++) {
		edges[edgeCnt++] = { planet_x[i], planet_x[i + 1], calcDistance(planet_x[i], planet_x[i + 1]) };
		edges[edgeCnt++] = { planet_y[i], planet_y[i + 1], calcDistance(planet_y[i], planet_y[i + 1]) };
		edges[edgeCnt++] = { planet_z[i], planet_z[i + 1], calcDistance(planet_z[i], planet_z[i + 1]) };
	}
	
	for (int i = 0; i < edgeCnt; i++) {
		edges_w[i] = i;
		p[i] = i;
	}

	mergeSort(edges_w, 0, edgeCnt - 1, compW);

	ll ans = 0;
	int sel = 0;
	
	for (int i = 0; i < edgeCnt; i++) {
		Edge e = edges[edges_w[i]];

		if (!unite(e.a, e.b))
			continue;

		ans += e.weight;
		if (++sel == N - 1) {
			break;
		}
	}
	printf("%lld", ans);
	return 0;
}