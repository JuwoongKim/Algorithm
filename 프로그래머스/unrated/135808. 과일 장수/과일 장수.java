import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> list =  Arrays.stream(score).boxed().collect(Collectors.toList());
        Collections.sort(list, (a,b) -> b-a);
        
        for(int i =0 ; i<list.size(); i++)
            if(i%m==m-1)
                answer +=m*list.get(i);
        
        return answer;
    }
}