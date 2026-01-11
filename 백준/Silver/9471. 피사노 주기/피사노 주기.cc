#include <stdio.h>

using ll = long long;

ll P, N, M;
ll prev, cur, tmp;


int main() {


	scanf("%ld", &P);
	for (int i = 0; i < P; i++) {
		scanf("%d%d", &N, &M);

		prev = 0; 
		cur = 1;
		for (ll j = 0; j < M * M; j++) {
			tmp = (prev + cur) % M;
			prev = cur;
			cur = tmp;
			if (prev == 0 && cur == 1) {
				printf("%d %d\n", N, j + 1);
				break;
			}
		}

	}


}