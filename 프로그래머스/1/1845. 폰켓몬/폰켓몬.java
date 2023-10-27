import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();     
        int n = nums.length;
        for(int i = 0; i < n; i++)
            set.add(nums[i]);
        
        int size = set.size();
        
        if(size > n/2)
            size = n/2;

        return size;
    }
}