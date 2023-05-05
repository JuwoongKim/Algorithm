import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            answer += (n/a)*b; 
            int mod = n%a;
            n = (n/a)*b+mod;
           
        }        
        
        return answer;
    }
}