#include <iostream>
#include <queue>

using namespace std;
int visited[1'000'005];

struct Number { int integer; string binary; };

string getBinary(int n, int len) {
	string result;
	int curLen = 0;
	while (n > 0) {
		result = (n & 1 ? '1' : '0') + result;
		n >>= 1;
		curLen++;
	}
	if(curLen < len)
		result.insert(0, len - curLen, '0');
	return result; 
}

int getInteger(const string& str) {
	int number = 0;
	int degree = 1;
	for (int i = str.length() - 1; i >= 0; i--) {
		if (str[i] == '1')
			number += degree;
		degree <<= 1;
	}
	return number;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	string nstr = getBinary(n, 0);
	int strLen = nstr.length();

	int m;
	cin >> m;

	queue<Number> q;

	int num;
	for (int i = 0; i < m; i++) {
		cin >> num;
		q.push({num, getBinary(num, strLen)});
		visited[num] = 1;
	}
	Number cur;
	while (!q.empty()) {
		cur = q.front(); q.pop();

		int degree = 1;
		for (int i = strLen - 1; i >= 0; i--) {
			int nNum = cur.integer + (cur.binary[i] == '0' ? degree : -degree);
			degree <<= 1;
			if (nNum > n || visited[nNum])
				continue;
			string nStr = cur.binary;
			nStr[i] = (nStr[i] == '0' ? '1' : '0');

			q.push({ nNum, nStr });
			visited[nNum] = visited[cur.integer] + 1;
			
		}
	}

	cout << visited[cur.integer] - 1;
}