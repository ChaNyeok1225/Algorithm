#include <stdio.h>

using ll = long long;
constexpr int MOD = 1'000;
constexpr int SZ = 5;

ll N, B;
ll map[SZ + 1][SZ + 1];
ll tmp[SZ + 1][SZ + 1];
ll ans[SZ + 1][SZ + 1];

void Matrix_multi(ll x[SZ + 1][SZ + 1], ll y[SZ + 1][SZ + 1]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			tmp[i][j] = 0;
			for (int k = 0; k < N; k++) {
				tmp[i][j] += x[i][k] * y[k][j];
			}
			tmp[i][j] %= MOD;
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			x[i][j] = tmp[i][j];
		}
	}
}

int main() {

	scanf("%ld%ld", &N, &B);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &map[i][j]);
		}
		ans[i][i] = 1;
	}

	for (; B; B >>= 1) {
		if (B & 1) {
			Matrix_multi(ans, map);
		}
		Matrix_multi(map, map);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", ans[i][j]);
		} printf("\n");
	}

}