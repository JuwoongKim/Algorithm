import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        // 각숫자의 갯수를 저장할 자료구조 
        int [] x_cnt_arr = getCountArr(X);
        int [] y_cnt_arr = getCountArr(Y);
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i =9; i>=0; i--){
            
            if(x_cnt_arr[i]!=0 && y_cnt_arr[i]!=0){
                int num = Math.min(x_cnt_arr[i],y_cnt_arr[i]);
                for(int j=0; j<num; j++)
                    sb.append(String.valueOf(i));
            }
        }
        
        
        answer = sb.toString();
     
        //만약 아무것도 없거나 0만 있다면 
        if(answer.equals("")) answer = "-1";
        else if(answer.charAt(0)=='0') answer = "0";
        
        return answer;
    }
    
    
    public static int [] getCountArr(String s){
        
        int [] cnt_arr = new int [10];
        
        int num=0;
        for(String ele : s.split("")){
            num = Integer.parseInt(ele);
            cnt_arr[num] +=1;
        }
        
        return cnt_arr;
    }
    
}