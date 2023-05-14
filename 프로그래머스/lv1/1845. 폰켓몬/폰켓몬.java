import java.util.*;

class Solution {    
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for(int ele : nums)
            set.add(ele);
        
        if(set.size()>N/2){
            answer = N/2;
        }else{
            answer  = set.size();
        }
        
        
        
        return answer;
    }
}