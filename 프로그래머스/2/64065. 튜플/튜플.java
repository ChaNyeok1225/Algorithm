import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<int[]> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, "{}");
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(",".equals(str)) continue;
            
            int[] nums = Arrays.stream(str.split(","))
                .mapToInt(Integer :: parseInt )
                .toArray();
            
            list.add(nums);
        }
        Collections.sort(list, (a,b) -> a.length - b.length);
        
        int[] answer = new int[list.size()];
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        for(int[] nums : list) { 
            
            for(int num : nums) {
                if(!set.contains(num)) {
                    answer[idx++] = num;
                    set.add(num);
                    break;
                }
                set.add(num);
            }
            
        }

        
        return answer;
    }
}