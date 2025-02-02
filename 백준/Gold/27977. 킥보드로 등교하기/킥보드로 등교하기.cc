#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int L, N, K;
vector<int> v;

bool chk(int mid) {
	int cnt = 0;
	int dest = mid;

	for (int i = 1; i < v.size(); ++i) {
		if (dest < v[i]) {
			dest = v[i - 1] + mid;
			if (dest < v[i])
				return false;
			++cnt;
		}
	}

	if (cnt <= K)
		return true;
	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> L >> N >> K;
	
	int a;
	v.push_back(0);
	for (int i = 0; i < N; i++) {
		cin >> a;
		v.push_back(a);
	}
	v.push_back(L);
	sort(v.begin(), v.end());

	int l = 0, r = L, mid, ans = 0;

	while (l <= r) {
		mid = (l + r) >> 1;

		if (chk(mid)) {
			r = mid - 1;
			ans = mid;
		}
		else
			l = mid + 1;
	}

	cout << ans;
}