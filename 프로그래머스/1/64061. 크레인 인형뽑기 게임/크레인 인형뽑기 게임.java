import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        ArrayDeque<Integer>[] map = new ArrayDeque[m + 1];
        for(int i = 0; i < m; i++) {
            map[i] = new ArrayDeque<>();
            for(int j = n-1; j >= 0; j--) {
                if(board[j][i] == 0)
                    break;
                map[i].offer(board[j][i]);
            }
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        Integer pick;
        for(int i = 0; i < moves.length; i++) {
            pick = map[moves[i] - 1].pollLast();
            if(pick == null)
                continue;
            if(stack.peekLast() == pick) { 
                answer += 2;
                stack.pollLast();
            }
            else
                stack.offer(pick);
        }
        
        return answer;
    }
}