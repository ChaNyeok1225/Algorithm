import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
                set.add(numbers[i] + numbers[j]);
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}