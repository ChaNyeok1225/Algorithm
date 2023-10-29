import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 1;
        int length = times.length;
        Arrays.sort(times);

        long maxTime = (long)times[0]*n;
        long minTime = 1;

        while(minTime<=maxTime){
            long averageTime = (minTime + maxTime)/2;
            long tmp_n = 0;

            for(int i=0;i<length;i++){
                tmp_n += averageTime / times[i];
                if(tmp_n > n) break;
            }

            if(n > tmp_n){
                minTime = averageTime + 1;
            }
            else{
                maxTime = averageTime - 1;
            }
        }


        return minTime;
    }
}