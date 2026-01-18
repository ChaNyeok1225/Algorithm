#include <stdio.h>

constexpr int SZ = 10'000;

struct Data {
	int p;
	int d;
};

struct PQ {
	Data arr[SZ + 5];
	int size = 0;
	bool flag = false;

	bool comp(Data a, Data b) {
		if (flag)
			return a.p < b.p;
		return a.d < b.d;
	}

	void offer(Data data) {
		int c = ++size;
		int p = c >> 1;
		while (p > 0) {
			if (comp(arr[p], data))
				break;
			arr[c] = arr[p];
			c = p;
			p >>= 1;
		}
		arr[c] = data;
	}

	void poll() {
		Data val = arr[size--];
		int p = 1;
		int c = p << 1;
		while (c <= size) {
			if (c + 1 <= size && comp(arr[c + 1], arr[c]))
				c++;
			if (comp(val, arr[c]))
				break;
			arr[p] = arr[c];
			p = c;
			c <<= 1;
		}
		arr[p] = val;
	}

	Data top() {
		return arr[1];
	}
} pq;

int n;
int arr[SZ + 10][2];




int main() {

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d%d", &arr[i][0], &arr[i][1]);
		pq.offer({ arr[i][0], arr[i][1] });
	}

	Data d;
	for (int i = 0; i < n; i++) {
		d = pq.top(); pq.poll();
		arr[i][0] = d.p;
		arr[i][1] = d.d;
	}
	
	pq.flag = true;
	for (int i = 0; i < n; i++) {
		pq.offer({ arr[i][0], arr[i][1] });
		if (pq.size > arr[i][1]) {
			pq.poll();
		}
	}

	int ans = 0;
	while (pq.size) {
		ans += pq.top().p; pq.poll();
	}
	printf("%d", ans);

	return 0;
}