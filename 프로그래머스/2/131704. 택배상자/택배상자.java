import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        int boxSeq = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int selBox;
        while(idx < order.length) {
            selBox = order[idx];

            if(!stack.isEmpty() && stack.peekLast() == selBox) {
                idx++;
                stack.pollLast();
            } else if (selBox == boxSeq) {
                idx++;    
                boxSeq++;
            } else {
                if(boxSeq >= order.length)
                    break;
                stack.offer(boxSeq++);
            }
            
        }
        
        
        return idx;
    }
}