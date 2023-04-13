import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        int c1N = cards1.length;
        int c2N = cards2.length;
        int gN = goal.length;
        
        boolean isSatisfied = true;
            
        for(int i =0,c1= 0, c2=0 ; i<gN; i++){
            
            if(!isSatisfied) break;
            isSatisfied =false;
            
            String temp = goal[i];
        
            if(c1<c1N && cards1[c1].equals(temp)){
                isSatisfied = true;
                c1 ++;
                continue;
            }
            
            if(c2<c2N && cards2[c2].equals(temp)){
                isSatisfied = true;
                c2 ++;
                continue;
            }            
        }
                
        answer = (isSatisfied) ? "Yes" : "No";
        return answer;
    }
}