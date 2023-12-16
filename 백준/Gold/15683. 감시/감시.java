import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m,ans= Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<int[]> list;
    static int[] dx= {-1, 0, 1, 0}; //상우하좌
    static int[] dy= {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        map= new int[n][m];
        list= new ArrayList<int[]>();

        for(int i=0; i<n; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {

                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new int[] {i,j,map[i][j]});
                }
            }
        }

        //시뮬+조합
        //list를 돌면서 하나씩 90도씩 돌아본다
       dfs(0);

        System.out.print(ans);

    }


    private static void dfs(int idx) {

        if(idx == list.size()) { // list를 다 돌았으면 사각지대 계산하기

            int cnt= 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 0) {
                        cnt+=1;
                    }
                }
            }
            
            ans= Math.min(ans, cnt);
            return;
        }

        int cctvNum= list.get(idx)[2]; //현재 맵에서 cctv 넘버
        int x= list.get(idx)[0];
        int y= list.get(idx)[1];
        
        //지금 있는 경우에 90도를 돌린다
        for(int i=0; i<4; i++) {
    
            if(cctvNum == 1) {
                //한 방향으로 cctvNum번호로 map에 표시한다
                lineMap(idx+7, (i+4)%4, x, y);
                dfs(idx+1);
                //원상복구
                lineMap(idx+7, (i+4)%4, x, y);
            }

            if(cctvNum == 2) {
                //1,3 or 0, 2
                if(i == 0) {
                    lineMap(idx+7, 0, x, y);
                    lineMap(idx+7, 2, x, y);
                    dfs(idx+1);
                    lineMap(idx+7, 0, x, y);
                    lineMap(idx+7, 2, x, y);
                    
                }
                
                if(i == 1) {
                    lineMap(idx+7, 1, x, y);
                    lineMap(idx+7, 3, x, y);
                    dfs(idx+1);
                    lineMap(idx+7, 1, x, y);
                    lineMap(idx+7, 3, x, y);
                }
            }

            if(cctvNum == 3) {
                // 0,1 or 1,2 or 2,3 or 3,0
                
                    lineMap(idx+7, (i+4)%4, x, y);
                    lineMap(idx+7, (i+5)%4, x, y);
                    dfs(idx+1);
                    lineMap(idx+7, (i+4)%4, x, y);
                    lineMap(idx+7, (i+5)%4, x, y);

            }

            if(cctvNum == 4) {
                 
                //0,1,2 or 1,2,3 or 0,2,3 or 0,1,3
                
                lineMap(idx+7, (i+4)%4, x, y);
                lineMap(idx+7, (i+5)%4, x, y);
                lineMap(idx+7, (i+6)%4, x, y);
                dfs(idx+1);
                lineMap(idx+7, (i+4)%4, x, y);
                lineMap(idx+7, (i+5)%4, x, y);
                lineMap(idx+7, (i+6)%4, x, y);
                
            }

            if(cctvNum == 5) {
                
                lineMap(idx+7, 0, x, y);
                lineMap(idx+7, 1, x, y);
                lineMap(idx+7, 2, x, y);
                lineMap(idx+7, 3, x, y);
                dfs(idx+1);
                lineMap(idx+7, 0, x, y);
                lineMap(idx+7, 1, x, y);
                lineMap(idx+7, 2, x, y);
                lineMap(idx+7, 3, x, y);
            }
        }
    }


    private static void lineMap(int idx, int dir, int x, int y) { //벽에 부딪히거나 맵의 끝에 닿을 때까지 dir방향으로 cctvNum을 표시한다.

        int nx= x; int ny= y;

        while(true) {
            nx= nx+ dx[dir];
            ny= ny+ dy[dir];

            if(nx<0 || ny<0 || nx>=n || ny>=m) break; 
            
            if(map[nx][ny] == 6) break;
            
            if(map[nx][ny] == idx)
            	map[nx][ny] = 0;
            else if (map[nx][ny] == 0)
            	map[nx][ny] = idx;
        }
    }

}