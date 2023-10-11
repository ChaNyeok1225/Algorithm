class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 3, y = 3;
        int yarea = 0, barea = 0;
        while(true) {
            yarea = (x-2) * (y-2);
            if(yarea != yellow) {
                if(yarea > yellow) {
                    y++;
                    x=y;    
                }
                else 
                    x++;
                continue;
            }
            
            barea = x*2 + 2*(y-2);
            if(barea == brown) {
                break;
            } else {
                y++;
                x=y;
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
}