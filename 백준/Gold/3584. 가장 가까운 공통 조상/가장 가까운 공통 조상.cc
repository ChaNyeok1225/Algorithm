#include <iostream>
using namespace std;

int T, N;
int nodes[10001];
bool chk[10001];

int A, B, answer;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> T;
	
	while (T-- > 0) {

		cin >> N;

		for (int i = 0; i < N - 1; i++) {
			cin >> A >> B;
			nodes[B] = A;
		}

		cin >> A >> B;

		while (A != 0) {
			chk[A] = true;
			A = nodes[A];
		}

		while (B != 0) {
			if (chk[B]) {
				answer = B;
				break;
			}
			B = nodes[B];
		}

		cout << answer << '\n';

		for (int i = 0; i < N; i++) {
			nodes[i] = 0;
			chk[i] = false;
		}
	}
	
}