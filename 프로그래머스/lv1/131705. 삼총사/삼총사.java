import java.util.*;

class Solution {

    public static boolean [] visit; 
    public static int answer;
    
    public int solution(int[] number) {
        
        answer = 0;
        visit = new boolean [number.length];
        
        int [] memo = new int[3];
        func(0, 0, memo, number);
        
        return answer;
    }
    
    public static void func( int level, int start, int [] memo, int[] number){
        
        if(level==3){
            //System.out.println(Arrays.toString(memo));
            int tempSum=0;
            for(int ele : memo)
                tempSum +=ele;
            if(tempSum==0) answer ++;
            return;
        }
        
        for(int i =start; i<number.length; i++){
            if(visit[i]) continue;
            memo[level] = number[i];
            visit[i] = true;
            func(level+1, i+1 ,memo, number);
            visit[i] = false;
        }
    }
    
}