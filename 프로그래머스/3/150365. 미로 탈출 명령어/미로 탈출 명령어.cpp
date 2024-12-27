#include <string>
using namespace std;

// 문제 키워드
// -   (x, y)에서 출발해 (r, c)로 이동
// -   이동하는 거리는 반드시 총 k 번
// -   같은 격자를 방문해도 됨
// -   탈출한 경로를 리턴, 문자열이 사전 순으로 가장 빠르게 탈출할 것
// -   d(아래), l(왼), r(오), u(위) 순
// -   탈출이 불가능하다면 "impossible" return

// 접근법
// -   k번 이동으로 탈출 가능한지 판단하기 위해서 k - (x, y)와 (r, c) 가 짝수인지 확인
//         - 짝수가 아니면 "impossible"
// -   DFS를 통해 경로를 탐색  / d(아래), l(왼), r(오), u(위)
//         -  각 탐색 격자마다 남은 거리 < 남은 이동횟수, 남은 이동 횟수 - (curX, curY)와 (r, c)가 짝수인지 확인을 통해 검정 및 백트래킹


void Dfs(int curX, int curY, int k, string str);

int N, M, R, C, K;
int dr[] = {1, 0, 0, -1}, dc[] = {0, -1, 1, 0};
char dir[] = {'d', 'l', 'r', 'u'};
int map[50][50];

bool flag = false;
string answer = "";

string solution(int n, int m, int x, int y, int r, int c, int k) {
    
    N = n;
    M = m;
    x--; y--;
    R = r - 1;
    C = c - 1;
    K = k;
    
    int calc = abs(x - R) + abs(y - C);
    if(k < calc || ((k - calc) & 1) == 1) 
        return "impossible";
    
    Dfs(x, y, k, "");
    
    return answer;
}

void Dfs(int curX, int curY, int k, string str) {
    if(flag || k < 0)
        return;
    if(curX < 0 || curX >= N || curY < 0 || curY >= M)
        return;
    
    if(curX == R && curY == C && k == 0) {
       answer = str;
       flag = true;
       return;
    }
    
    int calc = abs(curX - R) + abs(curY - C);
    if(k < calc)
        return;
    if(((k - calc) & 1) == 1) 
        return;
    
    for(int d = 0; d < 4; d++) {
        Dfs(curX + dr[d], curY + dc[d], k - 1, str + dir[d]);
    }
    
}
