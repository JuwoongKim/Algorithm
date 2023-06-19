import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int [] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : arr){
            if(max<ele){
                max = ele;
            }
            if(min>ele){
                min = ele;
            }
        }
            
        answer = String.format("%d %d",min, max);
        
        return answer;
    }
}