import java.util.*;

class Solution {
    
    static boolean[][] pillar;
    static boolean[][] beam;
    static int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        N = n + 1;
        pillar = new boolean[n+2][N];
        beam = new boolean[n+2][N];
        
        int type, act;
        for(int[] info : build_frame) {
            type = info[2];
            act = info[3];
            if(act == 0) {
                remove(info[2], info[1], info[0]);
            } else {
                build(info[2], info[1], info[0]);
            }
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        int[] arch;
        for(int c = 0; c < N; c++) {
            for(int r = 0; r < N; r++) {
                if(pillar[r][c])
                    list.add(new int[] {c, r, 0});
                if(beam[r][c])
                    list.add(new int[] {c, r, 1});
            }
        }
        
        answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    void build(int type, int r, int c) {
        if(type == 0) {
            if(invalidPillarBuild(r, c))
                return;
            pillar[r][c] = true;
        } else {
            if(invalidBeamBuild(r, c))
                return;
            beam[r][c] = true;
        }
    }
    
    boolean invalidBeamBuild(int r, int c) {
        if(pillar[r-1][c] || pillar[r-1][c+1])
            return false;
        else if(c > 0 && beam[r][c-1] && c < beam[0].length - 1 && beam[r][c+1])
            return false;
        return true;
    }
    
    boolean invalidPillarBuild(int r, int c) {
        if(r == 0)
            return false;
        else if(pillar[r-1][c])
            return false;
        else if(beam[r][c] || (c > 0 && beam[r][c-1]))
            return false;
        return true;
    }
    
    void remove(int type, int r, int c) {
        if(type == 0) {
            pillar[r][c] = false;
            if(checkBuild())
                return;
            pillar[r][c] = true;
        } else {
            beam[r][c] = false;
            if(checkBuild())
                return;
            beam[r][c] = true;
        }
    }
    
    boolean checkBuild() {
        for(int r = 0; r < N; r++) {
            for(int  c = 0; c < N; c++) {
                if(pillar[r][c])
                    if(invalidPillarBuild(r,c))
                        return false;
                if(beam[r][c])
                    if(invalidBeamBuild(r,c))
                        return false;
            }
        }
        return true;
    }
    
}