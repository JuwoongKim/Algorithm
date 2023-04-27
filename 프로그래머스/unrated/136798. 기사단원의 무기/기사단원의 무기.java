import java.util.*;

class Solution {

    public int solution(int number, int limit, int power) {
        int answer = 0;    
        int [] arr = new int [number+1];
        
        for(int i =1; i<=number; i++){      
            int n = getNumber(i);
            if(n>limit) n =power;
            arr[i] = n;
        }

        for(int ele : arr)
            answer += ele;
        return answer;
    }
    
    public static int getNumber(int n){
        	
        int count =0;
        for(int i=1; i*i<=n; i++){
            if(i*i ==n) count++;
            else if(n%i==0) count+=2;
        }
        return count;
    }
    
}