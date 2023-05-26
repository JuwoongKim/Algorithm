import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        int [] arr = IntStream.rangeClosed(1,n).toArray();
        
        int st =0;
        int ed =0;
        
        int sum =0;
        for(ed=0; ed <n; ed ++){
            
            sum += arr[ed];
            
            while(sum>n){
                sum -= arr[st];
                st ++;
            }
            
             if(sum ==n) answer ++; 
        }
        
        return answer;
    }
}