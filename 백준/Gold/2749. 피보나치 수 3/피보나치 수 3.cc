#include <stdio.h>

using ll = long long;
constexpr int MOD = 1'000'000;
constexpr int CYCLE = 1'500'000;

ll n;
ll fibo[CYCLE + 5];

int main() {


	scanf("%ld", &n);
	
	fibo[0] = 0;
	fibo[1] = 1;
	for (int i = 2; i <= (n % CYCLE); i++) {
		fibo[i] = (fibo[i - 2] + fibo[i - 1]) % MOD;
	}

	printf("%d", fibo[n % CYCLE]);

}