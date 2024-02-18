import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        
        int mlen = minerals.length;
        int flen = (mlen-1)/5 + 1;
        int[][] fatigue = new int[flen][3];
        
        int nop = 0;
        for(int i = 0; i < 3; i++)
            nop += picks[i];
        
        for(int i = 0; i < mlen; i++) {
            String mineral = minerals[i];
            int index = i / 5;
            
            fatigue[index][0]++;
            switch(mineral.charAt(0)) {
                case 'd' :
                    fatigue[index][1]+= 5;
                    fatigue[index][2]+= 25;
                    break;
                case 'i':
                    fatigue[index][1]+= 1;
                    fatigue[index][2]+= 5;
                    break;
                case 's':
                    fatigue[index][1]+= 1;
                    fatigue[index][2]+= 1;
                    break;
            }
        }
        
        for(int i = 0; i < 3; i++) {
            mine(i, 0, 0, flen, nop, picks, fatigue);
        }
        
        return answer;
    }
    
    static void mine(int pick, int index, int total, int flen, int nop, int[] picks, int[][] fatigue) {
        if(flen == index || index == nop) {
            answer = answer < total? answer : total;
            return;
        }
        
        if(picks[pick] == 0) 
            return;
        
        for(int i = 0; i < 3; i++) {
            picks[pick]--;
            mine(i, index+1, total + fatigue[index][pick], flen, nop, picks, fatigue);
            picks[pick]++;
        }
        
        
    }
    
}