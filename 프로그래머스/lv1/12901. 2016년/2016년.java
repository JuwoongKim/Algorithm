import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
    
        Integer [] cntList = {1,3,5,7,8,10,12};
        List<Integer> list = Arrays.asList(cntList);
                             
        String [] arr  = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int day =0;
        for(int i =1; i<a; i++){
            if(i==2){
                day+=29;
                continue;
            } 
            if(list.contains(i))day+=31;
            else day+=30;
        }
        
        day+=b;
        
        int temp =day%7;
        if(temp==0) temp=7;
    
        answer = arr[temp-1];

        return answer;
    }
}