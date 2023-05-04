import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        int md =0;
        while(storey!=0){

            md = storey%10;
            storey = storey/10;
            
             // System.out.println(md);
             // System.out.println(storey);
            
            if(md>5) {
                answer +=(10-md);
                storey +=1;
            }
            else if (md==5){
                if(storey%10>=5){
                    answer +=(10-md);
                    storey +=1;
                }else{
                    answer +=md;
                }
            }
            else answer +=md;
        }
                   

        return answer;
    }
}