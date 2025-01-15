// 키워드
// - 로봇은 2 x 1 크기
// - board 크기는 최대 100 x 100
// - 0은 빈칸, 1은 벽
// - 가능한 행동
//     - 형태를 유지하며 이동
//     - 하나를 축으로 하여 회전, 대각에 벽이 없을 때 가능
//     - 1초 소모
// - 최소 시간을 return, 항상 도착 가능

// 접근법
// - DP / DFS / BFS / PQ 
// - DP 풀이
//     - [r][c][형태]
//     - 상향식 DP
//         - 아래와 오른쪽으로만 갈 수 있는게 아니라서 부적합
// - DFS
//     - 회전, 이동 등의 분기가 너무 많아서 터질 것 같음
// - BFS
//     - *가능할지도 
// - PQ로 풀이
//     - 분기가 너무 많이 일어남

// - BFS로 푼다면?
//     - 상태를 [R][C][다른쪽의 방향]로 저장 [N][N][4]
//     - 처음에 큐에 넣는건 [0][0][오른쪽], [0][1][왼쪽]
//     - 이렇게 해서 완탐하면 되지 않을까?   

#include <vector>

using namespace std;

struct e { int r; int c; int dir; };

int solution(vector<vector<int>> board) {
    int answer = 1'000'000;
    const int N = board.size();
    
    // 위, 오른쪽, 아래, 왼쪽
    int vis[N][N][4];
    
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, 1, 0, -1};
    int rot[] = {1, -1};
    
    int qsz = 1 << 15;
    e q[qsz];
    int l = 0, r = 0;
        
    q[r++] = {0, 0, 1};
    vis[0][0][1] = 1;
    
    q[r++] = {0, 1, 3};
    vis[0][1][3] = 1;
    
    int end = N - 1;
    while(l < r) {
        e cur = q[l++];
        l &= ~qsz;
        
        if(cur.r == end && cur.c == end) {
            answer = vis[cur.r][cur.c][cur.dir] - 1;
            break;
        }
        
        int ar = cur.r + dr[cur.dir];
        int ac = cur.c + dc[cur.dir];
        
        // 상하좌우 이동
        for(int d = 0; d < 4; d++) {
            int nr = cur.r + dr[d];
            int nc = cur.c + dc[d];
            int nar = ar + dr[d];
            int nac = ac + dc[d];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc])
                continue;
            if(nar < 0 || nar >= N || nac < 0 || nac >= N || board[nar][nac]) 
                continue;
            
            if(!vis[nr][nc][cur.dir]) {
                vis[nr][nc][cur.dir] = vis[cur.r][cur.c][cur.dir] + 1;
                q[r++] = {nr, nc, cur.dir};
                r &= ~qsz;
            }
            
            int ndir = cur.dir ^ 0b10;
            if(!vis[nar][nac][ndir]) {
                vis[nar][nac][ndir] = vis[cur.r][cur.c][cur.dir] + 1;
                q[r++] = {nar, nac, ndir};
                r &= ~qsz;
            }
        }
        
        // 회전
        for(int d = 0; d < 2; d++) {
            int ndir = ((cur.dir + rot[d]) & 0b11);
            int nar = cur.r + dr[ndir];
            int nac = cur.c + dc[ndir];
            
            if(nar < 0 || nar >= N || nac < 0 || nac >= N || board[nar][nac])
                continue;
            
            int odr = dr[cur.dir] + dr[ndir];
            int odc = dc[cur.dir] + dc[ndir];
            
            if(board[cur.r + odr][cur.c + odc])
                continue;
            
            if(!vis[cur.r][cur.c][ndir]) {
                vis[cur.r][cur.c][ndir] = vis[cur.r][cur.c][cur.dir] + 1;
                q[r++] = {cur.r, cur.c, ndir};
                r &= ~qsz;
            }
            
            ndir = ndir ^ 0b10;
            if(!vis[nar][nac][ndir]) {
                vis[nar][nac][ndir] = vis[cur.r][cur.c][cur.dir] + 1;
                q[r++] = {nar, nac, ndir};
                r &= ~qsz;
            }
            
        }
    }
    
    return answer;
}