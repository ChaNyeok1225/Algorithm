#include <stdio.h>
#define MIN(A, B) A < B ? A : B

using ll = long long;

constexpr int MAX_N = 500;
constexpr int MAX_M = 6'000;
constexpr int INF = 1'234'567'890;
constexpr int QS = 1 << 10;
constexpr int QM = QS - 1;

int N, M;
struct Edge {
	int from;
	int to;
	int weight;
	int next;
} edges[MAX_M + 5];
int adj[MAX_N + 5], count[MAX_N + 5];
ll dist[MAX_N + 5];
bool isExist[MAX_N + 5];

int que[QS];
int front, rear;

int main() {

	scanf("%d %d", &N, &M);

	int a, b, c;
	for (int i = 1; i <= M; i++) {
		scanf("%d %d %d", &a, &b, &c);
		edges[i] = { a, b, c };
		edges[i].next = adj[a];
		adj[a] = i;
	}

	for (int i = 2; i <= N; i++) {
		dist[i] = INF;
	}

	que[rear++] = 1;
	isExist[1] = true;
	count[1]++;

	bool isCycle = false;
	while (front != rear && !isCycle) {
		int cur = que[front++];
		front &= QM;
		isExist[cur] = false;
		
		for (int v = adj[cur]; v != 0; v = edges[v].next) {

			Edge e = edges[v];
			if (dist[e.to] <= dist[e.from] + e.weight)
				continue;

			dist[e.to] = dist[e.from] + e.weight;
			if (isExist[e.to])
				continue;

			que[rear++] = e.to;
			rear &= QM;
			isExist[e.to] = true;
			count[e.to]++;
			if (count[e.to] > N) {
				isCycle = true;
				break;
			}
		}
	}

	if (isCycle) {
		printf("-1");
	}
	else {
		for (int i = 2; i <= N; i++) {
			printf("%lld\n", dist[i] == INF ? -1 : dist[i]);
		}
	}
	
	return 0;
}