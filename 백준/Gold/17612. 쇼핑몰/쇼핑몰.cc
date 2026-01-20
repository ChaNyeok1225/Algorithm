#include <stdio.h>

using ll = long long;

constexpr int SZ = 100'000;

struct Data {
	int index;
	int id;
	int time;
};

struct PQ {
	Data arr[SZ + 5];
	int size = 0;

	bool comp(Data a, Data b) {
		if (a.time == b.time)
			return a.index > b.index;
		return a.time < b.time;
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

int N, K;
ll ans = 0;

int main() {
	scanf("%d%d", &N, &K);

	for (int i = 1; i <= K; i++) {
		pq.offer({ -i, 0, 0 });
	}

	Data d;
	int id, w;
	ll cur = 0, seq = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d%d", &id, &w);

		d = pq.top();
		cur = d.time;
		while (d.index > 0 && d.time == cur) {
			ans += ++seq * d.id;
			pq.poll();
			pq.offer({ -d.index, d.id, d.time });
			d = pq.top();
		}

		if (d.index < 0) {
			pq.poll();
			pq.offer({ -d.index, id, d.time + w });
		}
	}

	d = pq.top();
	while (pq.size) {
		if(d.index > 0)
			ans += ++seq * d.id;
		pq.poll();
		d = pq.top();
	}
	printf("%lld", ans);

	return 0;
}