import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n!=0){
            if(n%2 ==0){
                // 짝수라면
                n /=2;
            } else {
                // 홀수라면
                n -=1;
                ans ++;
            }            
        }

        return ans;
    }
}