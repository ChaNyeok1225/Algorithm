#include <iostream>
#include <algorithm>
using namespace std;

struct Time {
	int f;
	int s;

	bool operator<(const Time& t) const {
		return s == t.s ? f < t.f : s < t.s;
	}
};

Time arr[200'001];
int q[3];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	int n, k;
	cin >> n >> k;

	int f, s;
	for (int i = 0; i < n; i++) {
		cin >> f >> s;
		arr[i] = { f , s };
	}
	sort(arr, arr + n);

	int ans = 0;

	for (int i = 0; i < n; i++) {
		Time t = arr[i];

		for (int j = k - 1; j >= 0; j--) {
			if (q[j] < t.f) {
				q[j] = t.s;
				++ans;
				break;
			}
		}
		sort(q, q + k);
	}
	
	cout << ans;

}