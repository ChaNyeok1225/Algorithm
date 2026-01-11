#include <stdio.h>

using ll = long long;
constexpr int SZ = 4'000'000;
constexpr ll MOD = 1'000'000'007;

int N, K;

ll pow(ll a, ll b) {
	ll res = 1;
	for (; b; b >>= 1, a = a * a % MOD) {
		if (b & 1) {
			res = res * a % MOD;
		}
	}
	return res;

}

ll Fac[SZ + 1], Inv[SZ + 1];

int main() {

	scanf("%d%d", &N, &K);

	Fac[0] = 1;
	for (int i = 1; i <= N; i++) {
		Fac[i] = Fac[i - 1] * i % MOD;
	}
	Inv[N] = pow(Fac[N], MOD - 2);
	for (int i = N - 1; i >= 0; i--) {
		Inv[i] = Inv[i + 1] * (i + 1) % MOD;
	}

	ll ans = Fac[N] * Inv[K] % MOD * Inv[N - K] % MOD;
	printf("%ld", ans);
}