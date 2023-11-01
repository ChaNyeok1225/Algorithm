import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int acnt = 0, bcnt = 0, ccnt = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i % a.length])
                acnt++;
            if(answers[i] == b[i % b.length])
                bcnt++;
            if(answers[i] == c[i % c.length])
                ccnt++;
        }    
        
        int max = acnt < bcnt? (bcnt < ccnt ? ccnt : bcnt ): (acnt < ccnt ? ccnt : acnt);
        
        List<Integer> list = new ArrayList<>();
        if(acnt==max)
            list.add(1);
        if(bcnt==max)
            list.add(2);
        if(ccnt==max)
            list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}