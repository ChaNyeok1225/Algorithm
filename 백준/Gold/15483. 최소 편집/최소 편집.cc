#include <stdio.h>

constexpr int MAX_LEN = 1'005;

char S[MAX_LEN];
char T[MAX_LEN];

int DP[MAX_LEN][MAX_LEN];

inline int MIN(int a, int b, int c) {
	int ret = a < b ? a : b;
	ret = ret < c ? ret : c;
	return ret;
}

int main() {

	scanf("%s", (S + 1));
	scanf("%s", (T + 1));

	int SL, TL;
	for (SL = 1; S[SL]; SL++) {
		DP[SL][0] = SL;
	}

	for (TL = 1; T[TL]; TL++) {
		DP[0][TL] = TL;
	}


	for (int i = 1; S[i]; i++) {
		for (int j = 1; T[j]; j++) {
			if (S[i] == T[j]) {
				DP[i][j] = DP[i - 1][j - 1];
			}
			else {
				DP[i][j] = MIN(DP[i][j - 1] + 1, DP[i - 1][j] + 1, DP[i - 1][j - 1] + 1);
			}
		}
	}

	printf("%d", DP[SL - 1][TL - 1]);

	return 0;
}