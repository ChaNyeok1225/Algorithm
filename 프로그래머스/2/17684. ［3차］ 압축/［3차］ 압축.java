import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int max = 1;
        for(int i = 0; i < 26; i++) {
            map.put(Character.toString(i+'A'), max++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));

            if(map.get(sb.toString()) == null) {
                map.put(sb.toString(), max++);
                sb.setLength(sb.length()-1);
                list.add(map.get(sb.toString()));
                sb.setLength(0);
                sb.append(msg.charAt(i));
            }
        }
        list.add(map.get(sb.toString()));
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}