import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String [] arr = s.split("");

        Arrays.sort(arr, (o1,o2)-> o2.compareTo(o1));
        
        StringBuilder sb =new StringBuilder("");
        for(String ele: arr)
            sb.append(ele);
        
        answer = sb.toString();
        
        return answer;
    }
}