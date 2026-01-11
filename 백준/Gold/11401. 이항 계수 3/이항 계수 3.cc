#include <stdio.h>

using ll = long long;
constexpr ll MOD = 1'000'000'007;

int N, K;

ll Pow(ll a, ll b) {
	ll res = 1;
	for (; b; b >>= 1, a = a * a % MOD) {
		if (b & 1) {
			res = res * a % MOD;
		}
	}
	return res;
}

int main() {

	scanf("%d%d", &N, &K);

	ll n = 1, k = 1;
	for (int i = 0; i < K; i++) {
		n *= N - i;
		k *= K - i;

		n %= MOD;
		k %= MOD;
	}

	k = Pow(k, MOD - 2);

	ll ans = n * k % MOD;
	printf("%ld", ans);
}