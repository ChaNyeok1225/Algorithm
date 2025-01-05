#include <iostream>
using namespace std;

int main() {
	int answer = 0;
	int n, m;
	cin >> n >> m;

	char A[50][50];
	char B[50][50];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> A[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> B[i][j];
		}
	}

	for (int i = 0; i < n - 2; i++) {
		for (int j = 0; j < m - 2; j++) {
			if (A[i][j] == B[i][j]) continue;
			
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					A[i + a][j + b] = A[i + a][j + b] == '0' ? '1' : '0';
				}
			}

			answer++;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (A[i][j] == B[i][j]) continue;
			cout << -1;
			return 0;
		}
	}

	cout << answer;
	return 0;
}