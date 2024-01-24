import java.util.*;

class Solution {
    
    static TreeMap<String,Integer> map = new TreeMap<>();
    static HashMap<Integer,Integer> mval = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        
        for(int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            comb(0, 0, order, course, new StringBuilder());
        }
        
        List<String> ans = new ArrayList<>();
        
        for(String key : map.keySet()) {
            int val = map.get(key);
            int len = key.length();
            if(val > 1 && mval.get(len) == val)
                ans.add(key);
        }
        
        String[] answer = new String[ans.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
    
    static void comb(int cnt, int idx, char[] order, int[] course, StringBuilder sb) {
        
        if(idx == course.length || cnt > order.length)
            return;
        if(sb.length() == course[idx]) {
            String str = sb.toString();
            int val = map.getOrDefault(str, 0) + 1;
            map.put(str, val);
            int maxval = mval.getOrDefault(course[idx], 0);
            maxval = maxval > val ? maxval : val;
            mval.put(course[idx], maxval);
            idx++;
        }
        for(int i = cnt; i < order.length; i++) {
            sb.append(order[i]);
            comb(i+1, idx, order, course, sb);
            sb.setLength(sb.length() - 1);
        }
    }
    
}