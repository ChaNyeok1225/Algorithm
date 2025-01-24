#include <iostream>

using namespace std;

int n, m;
struct Pos { int x; int y; };

Pos Find(int size, int walk) {
	// base condition
	if (size == 2) {
		switch (walk) {
		case 1:
			return { 1, 1 };
		case 2:
			return { 1, 2 };
		case 3:
			return { 2, 2 };
		case 4:
			return { 2, 1 };
		}
	}

	int half = size / 2;
	int section = half * half;

	Pos p;
	if (walk <= section) {
		p = Find(half, walk);
		return { p.y, p.x };
		// { 1, 1 } => { 1, 1 }
		// { 1, 2 } => { 2, 1 }
		// { 2, 2 } => { 2, 2 }
		// { 2, 1 } => { 1, 2 }
	}
	else if (walk <= 2 * section) {
		p = Find(half, walk - section);
		return { p.x, p.y + half };
		// { 1, 1 } => { 1, 3 }
		// { 1, 2 } => { 1, 4 }
		// { 2, 2 } => { 2, 4 }
		// { 2, 1 } => { 2, 3 }
	}
	else if (walk <= 3 * section) {
		p = Find(half, walk - 2 * section);
		return { p.x + half, p.y + half };
		// { 1, 1 } => { 3, 3 }
		// { 1, 2 } => { 3, 4 }
		// { 2, 2 } => { 4, 4 }
		// { 2, 1 } => { 4, 3 }
	}
	else {
		p = Find(half, walk - 3 * section);
		return { size + 1 - p.y, half + 1 - p.x };
		// { 1, 1 } => { 4, 2 }
		// { 1, 2 } => { 3, 2 }
		// { 2, 2 } => { 3, 1 }
		// { 2, 1 } => { 4, 1 }
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr); cout.tie(nullptr);

	int size, walk;
	cin >> size >> walk;
	Pos p = Find(size, walk);
	cout << p.x << " " << p.y;
}