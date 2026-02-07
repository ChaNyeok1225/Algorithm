#include <stdio.h>

constexpr int MAX_N = 500;
constexpr int MAX_M = 2'500;
constexpr int MAX_W = 200;
constexpr int QS = 1 << 15;
constexpr int QM = QS - 1;
constexpr int INF = 1'234'567'890;

struct Edge {
	int from;
	int to;
	int weight;
	int next;
} edges[5'500];

int dist[MAX_N + 1], count[MAX_N + 1], adj[MAX_N];
bool isExist[MAX_N + 1];
int edgeCnt = 0;

int que[QS];
int front, rear;

int main() {
	int TC;
	scanf("%d", &TC);

	while (TC--) {
		int N, M, W;
		scanf("%d %d %d", &N, &M, &W);

		for (int i = 0; i <= N; i++) {
			isExist[i] = count[i] = adj[i] = 0;
			dist[i] = INF;
		};
		edgeCnt = 0;
		front = rear = 0;

		int S, E, T;
		for (int i = 0; i < M; ++i) {
			scanf("%d %d %d", &S, &E, &T);
			edges[++edgeCnt] = { S, E, T, adj[S] };
			adj[S] = edgeCnt;
			edges[++edgeCnt] = { E, S, T, adj[E] };
			adj[E] = edgeCnt;
		}
		for (int i = 0; i < W; ++i) {
			scanf("%d %d %d", &S, &E, &T);
			edges[++edgeCnt] = { S, E, -T, adj[S] };
			adj[S] = edgeCnt;

			que[rear++] = S;
			dist[S] = 0;
			isExist[S] = true;
			count[S]++;
		}

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
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}

	}


	return 0;
}