#include <iostream>
using namespace std;

int arr[500005];
int stack[500005][2];
int n, pos;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; i++) 
		cin >> arr[i];

	long long answer = 0;
	int cnt = 0;

	for (int i = 0; i < n; i++) {
		cnt = 1;
		while (pos > 0 && stack[pos - 1][0] <= arr[i]) {
			answer += stack[pos - 1][1];
			if (stack[pos - 1][0] == arr[i])
				cnt += stack[pos - 1][1];
			--pos;
		}

		if (pos > 0)
			++answer;

		stack[pos][0] = arr[i];
		stack[pos][1] = cnt;
		++pos;
	}

	cout << answer;
}