import java.util.*;

class Solution {
    
    public static String [][] map;
    public static String [] direction = new String [] {"d", "l", "r", "u"};
    public static int  [] directionX = new int [] { 1, 0, 0, -1};
    public static int  [] directionY = new int [] { 0, -1, 1, 0};
    
    public static String ANSWER =""; 
    public static boolean isFind =false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        String answer = "";
        map = new String[n][m];
        
        
        if((k-(Math.abs(r - x) + Math.abs(c - y)))%2 != 0  || (Math.abs(r - x) + Math.abs(c - y)) >k ){
            answer = "impossible";
            return answer;
        }
        
        dfs (0, new ArrayList<String>(), x-1, y-1, r-1, c-1, k); 

        answer =ANSWER; 
        return answer;
    }
    
    
    public static void dfs (int level, List<String> memo, int x, int y, int r, int c, int k) {
        
        System.out.println(x + " , " + y);
        
        if(isFind) return;
        
        int distance = Math.abs(r - x) + Math.abs(c - y);
        if(distance > (k-level)) return ;
          
        if(distance == 0 && level ==k){
            StringBuilder sb= new StringBuilder("");
            
            for(String ele : memo)
                sb.append(ele);
            
            isFind = true;
            ANSWER = sb.toString();
           // System.out.println(sb.toString());
            
            return; 
        }
        
        for(int i =0; i<4; i++){
     
            int preX = x + directionX[i];
            int preY = y + directionY[i];
            
            if( preX<0 || preX>=map.length || preY<0 || preY >=map[0].length) continue;
            
            x= preX; 
            y= preY;
            memo.add(direction[i]);
            
            dfs(level+1, memo, x, y, r, c, k);
            
            if(isFind) break;
            
            x -= directionX[i];
            y -= directionY[i];
            memo.remove(memo.size()-1);
 
        }       
    }

    
}