#include <iostream>
using namespace std;


int N, M;
int jewel[300001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;

	int l = 1, r = 1;
	for (int i = 0; i < M; i++) {
		cin >> jewel[i];
		r = r > jewel[i] ? r : jewel[i];
	}

	int answer = 0;
	int mid, cnt;

	while (l <= r) {
		mid = (l + r) / 2;
		cnt = 0;
		for (int i = 0; i < M; i++) {
			cnt += ((jewel[i] - 1) / mid) + 1;
		}

		if (cnt <= N) {
			r = mid - 1;
			answer = mid;
		}
		else {
			l = mid + 1;
		}
	}

	cout << answer;

}