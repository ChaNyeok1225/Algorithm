#include <stdio.h>
#define MIN(A, B) A < B ? A : B

using ll = long long;

constexpr int MOD = 1'000'000'007;
int N, K;

ll Pow(ll a, ll b) {
	ll ret = 1;
	while (b) {
		if (b & 1)
			ret = (ret * a) % MOD;
		a = (a * a) % MOD;;
		b >>= 1;
	}
	return ret;
}

int main() {
	scanf("%d%d", &N, &K);
	K = MIN(K, N - K);

	ll a = 1;
	ll b = 1;

	for (int i = 0; i < K; i++) {
		a *= N - i;
		a %= MOD;
		b *= K - i;
		b %= MOD;
	}

	b = Pow(b, MOD - 2);
	printf("%lld", (a * b) % MOD);
	return 0;
}