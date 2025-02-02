#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define MX 100005

int p[MX];

int Find(int a) {
	if (a == p[a]) return a;
	return p[a] = Find(p[a]);
}

bool Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	if (a == b) 
		return true;

	p[a] = b;
	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		p[i] = i;
	}

	int a, b;
	int cycle = 0;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		if (Union(a, b))
			cycle++;
	}

	int area = 0;
	for (int i = 1; i <= n; i++) {
		if (i == Find(i))
			area++;
	}

	cout << area - 1 + cycle;
}