#include <stdio.h>
#define MIN(A, B) A < B ? A : B

constexpr int SZ = 500;
constexpr int INF = 0x7FFFFFFF;

int N;
int mat[SZ + 5][2];
int dp[SZ + 5][SZ + 5];

int main() {
	scanf("%d", &N);

	for (int i = 1; i <= N; i++) {
		scanf("%d%d", &mat[i][0], &mat[i][1]);
		dp[i][i] = 0;
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; i + j <= N; j++) {
			dp[j][i + j] = INF;
			for (int k = j; k <= i + j; k++) {
				dp[j][i + j] = MIN(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + (mat[j][0] * mat[k][1] * mat[i + j][1]));
			}
		}
	}

	printf("%d", dp[1][N]);

	return 0;
}