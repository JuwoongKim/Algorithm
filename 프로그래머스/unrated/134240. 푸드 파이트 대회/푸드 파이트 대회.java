import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder("");
        
        int N = food.length;
        for(int i =1; i<N; i++){
            if(food[i]%2==0){
                for(int j=0; j<food[i]/2; j++)
                    sb.append(i);
            }else{
                if(food[i]-1!=0){
                    for(int j=0; j<(food[i]-1)/2; j++)
                    sb.append(i);
                }
            }
        }
        
        String first = sb.toString();
        String end = sb.reverse().toString();        
        answer = first + "0" + end;

        return answer;
    }
}