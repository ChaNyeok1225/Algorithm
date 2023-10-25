import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        
        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++) 
            arr[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        
        ArrayList<Integer> list = new ArrayList<>();
        int prg = arr[0], cnt = 1;
        for(int i = 1; i < size; i++) {
            if(prg >= arr[i]) {
                cnt++;
            }
            else if(prg < arr[i]) {
                list.add(cnt);
                prg = arr[i];
                cnt = 1;
            }
        } list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0;  i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}