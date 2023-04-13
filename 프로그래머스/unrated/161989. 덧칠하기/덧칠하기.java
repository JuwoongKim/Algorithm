import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        Arrays.sort(section);
        
        int sIdx = 0;
        int cp = 0;
        while(true){
        
            int start = section[sIdx];
            cp = start + m;
            answer ++;
            
            while(section[sIdx] < cp){
                sIdx ++;
                if(sIdx == section.length) break;
            }
            
            if(sIdx == section.length) break; 
        }
        
        return answer;
    }
}