#include <iostream>
using namespace std;


int p[1000005];

int Find(int a) {
	if (a == p[a]) return a;
	return p[a] = Find(p[a]);
}

void Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	if (a == b)
		return;
	p[b] = a;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	int T;
	cin >> T;

	int tc = 0;
	while (++tc <= T) {
		int n, k;
		cin >> n;
		cin >> k;

		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		int a, b;
		for (int i = 0; i < k; i++) {
			cin >> a >> b;
			Union(a, b);
		}

		int m;
		cin >> m;

		cout << "Scenario " << tc << ":\n";
		for (int i = 0; i < m; i++) {
			cin >> a >> b;
			if (Find(a) == Find(b))
				cout << "1\n";
			else
				cout << "0\n";
		}
		cout << "\n";
	}
}