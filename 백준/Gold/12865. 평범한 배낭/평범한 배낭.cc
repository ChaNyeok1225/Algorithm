#include <stdio.h>


int N, K; 
int value[100][2];
int DP[100005];

int main() {

	scanf("%d%d", &N, &K);

	for (int i = 0; i < N; i++) {
		scanf("%d%d", &value[i][0], &value[i][1]);
	}

	for (int i = 0; i < N; i++) {
		for (int j = K; j >= value[i][0]; j--) {
			int tmp = DP[j - value[i][0]] + value[i][1];
			DP[j] = tmp > DP[j] ? tmp : DP[j];
		}
	}

	printf("%d", DP[K]);

	return 0;
}