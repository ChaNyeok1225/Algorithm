#include <stdio.h>

constexpr int SZ = 1'000'000;
constexpr int P_SZ = 200'000;
constexpr int NAME_SZ = 20;
constexpr int MOD = 1'000'007;
int idx;

struct P {
	int val;
	int cnt = 0;
} p[P_SZ + 100];

int F, N;

struct Data {
	char* name;
	int val = -1;
};

int hasing(char* name) {
	int h = 0;
	for (int i = 0; name[i] != 0; i++)
		h = (h * 31 + name[i]) % MOD;
	return h;
}

bool CompString(char* a, char* b) {
	int i;
	for (i = 0; a[i] != 0; i++) {
		if (a[i] != b[i])
			return false;
	}
	return b[i] == 0;
}

struct Hash {
	Data data[SZ + 100];

	void clear() {
		for (int i = 0; i < SZ + 100; i++) {
			data[i] = { nullptr, -1 };
		}
	}

	int put(char* name) {
		int h = hasing(name);
		int time = 1;
		while (true) {
			if (data[h].val == -1) {
				data[h] = { name, idx };
				return idx++;
			}
			if (CompString(name, data[h].name)) {
				return data[h].val;
			}
			h = (h + time * time) % MOD;
			time++;
		}
	}

} hash;


void Clear() {
	for (int i = 0; i < P_SZ + 100; i++) {
		p[i] = { i, 1 };
	}
}

int Find(int a) {
	if (p[a].val == a) return a;
	return p[a].val = Find(p[a].val);
}

void Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	if (a == b)
		return;

	p[a].cnt += p[b].cnt;
	p[b].val = a;
}


int main() {
	scanf("%d", &F);

	int h[2];
	while (F--) {
		Clear();
		hash.clear();
		idx = 0;

		scanf("%d", &N);
		for (int i = 0; i < N;
			i++) {
			for (int j = 0; j < 2; j++) {
				char* name = new char[NAME_SZ + 1];
				scanf("%s", name);
				h[j] = hash.put(name);
			}
			Union(h[0], h[1]);
			printf("%d\n",p[Find(h[0])].cnt);
		}
	}

	return 0;
}