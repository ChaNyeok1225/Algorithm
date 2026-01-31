#include <stdio.h>
constexpr int MAX_CITY = 1'000;
constexpr int MAX_EDGE = 250'000;
constexpr int MAX_K = 100;
constexpr int INF = 123'456'789;


int edgeCount = 0;
struct Edge {
	int vertex;
	int weight;
	int next;
} edges[MAX_EDGE + 5];

int adj[MAX_CITY + 1];

void addEdge(int u, int v, int w) {
	edgeCount++;
	edges[edgeCount].vertex = v;
	edges[edgeCount].weight = w;
	edges[edgeCount].next = adj[u];
	adj[u] = edgeCount;
}

template<typename Comp, int CAPA>
struct PQ {
	int size = 0;
	Edge arr[CAPA + 1];

	Comp comp;

	void push(const Edge& e) {
		int child = ++size;
		int parent = child >> 1;
		while (parent > 0) {
			if (comp.compare(arr[parent], e))
				break;
			arr[child] = arr[parent];
			child = parent;
			parent >>= 1;
		}
		arr[child] = e;
	}

	void pop() {
		Edge e = arr[size--];
		int parent = 1;
		int child = 2;
		while (child <= size) {
			if (child < size && comp.compare(arr[child + 1], arr[child]))
				child++;
			if (!comp.compare(arr[child], e))
				break;
			arr[parent] = arr[child];
			parent = child;
			child <<= 1;
		}
		arr[parent] = e;
	}

	Edge top() {
		return arr[1];
	}
};

struct MinComp {
	bool compare(const Edge& o1, const Edge& o2) {
		return o1.weight < o2.weight;
	}
};

struct MaxComp {
	bool compare(const Edge& o1, const Edge& o2) {
		return o1.weight > o2.weight;
	}
};

PQ<MinComp, 4 * MAX_EDGE> pq;
PQ<MaxComp, MAX_K> dists[MAX_CITY + 1];

int N, M, K;
int ansDist[MAX_CITY + 1];
int arriveCnt[MAX_CITY + 1];

int main() {

	scanf("%d%d%d", &N, &M, &K);
	
	int to, from, w;
	for (int i = 0; i < M; ++i) {
		scanf("%d%d%d", &to, &from, &w);
		addEdge(to, from, w);
	}

	for(int i = 1; i < N + 1; ++i) {
		ansDist[i] = -1;
	}

	pq.push({ 1, 0 });
	dists[1].push({ 1, 0 });

	int searchCnt = 0;
	int tryCnt = M * (K + 1);
	while (pq.size) {
		Edge e = pq.top();
		pq.pop();

		for (int cur = adj[e.vertex]; cur != 0; cur = edges[cur].next) {
			int nv = edges[cur].vertex;
			int nw = e.weight + edges[cur].weight;

			if (dists[nv].size < K) {
				dists[nv].push({ nv, nw });
				pq.push({ nv, nw });
			}
			else if (dists[nv].top().weight > nw) {
				dists[nv].pop();
				dists[nv].push({ nv, nw });
				pq.push({ nv, nw });
			}

		}
	}

	for (int i = 1; i < N + 1; ++i) {
		if (dists[i].size < K) printf("-1\n");
		else printf("%d\n", dists[i].top().weight);
	}

	return 0;
}