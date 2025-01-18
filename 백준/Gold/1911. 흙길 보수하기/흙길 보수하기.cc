#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int N, L;
	vector<pair<int, int>> v;
	
	cin >> N >> L;

	v.reserve(N);

	for (int i = 0; i < N; i++) {
		int s, e;
		cin >> s >> e;
		v.push_back(make_pair(s, e));
	}
	sort(v.begin(), v.end());

	int answer = 0;
	int cur = 0;

	for (int i = 0; i < N; i++) {
		if (cur < v[i].first)
			cur = v[i].first;
		if (cur >= v[i].second)
			continue;

		int diff = v[i].second - cur;
		int count = (diff - 1) / L + 1;
		answer += count;

		cur += count * L;
	}

	cout << answer;

}