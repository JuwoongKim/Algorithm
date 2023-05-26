import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, (o1,o2) ->{
            
            if(o1.charAt(n)==o2.charAt(n)){
                return o1.compareTo(o2);
            }else{
                return o1.charAt(n)-o2.charAt(n);
            }
            
        });
        
        answer = strings;
        return answer;
    }
}