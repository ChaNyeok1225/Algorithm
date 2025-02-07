#include <iostream>
#include <vector>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	int g;
	cin >> g;

	vector<int> v;

	long long e = 1;
	for (long long s = 1; s <= 100000; s++) {
		long long a = s * s;
		if (a <= g)
			continue;

		while (a - g > e * e) {
			++e;
		}
		if (a - g == e * e) {
			v.push_back(s);
		}
	}

	if (v.empty())
		cout << -1;
	else 
		for (int x : v)
			cout << x << "\n";

}