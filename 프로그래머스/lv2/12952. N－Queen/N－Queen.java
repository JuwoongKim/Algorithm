import java.util.*;

class Solution {
    
    public static int answer =0 ;
    
    public int solution(int n) {

        int [][] map = new int [n][n];
        func(0, map);
        
        return answer;
    }
    
    public static void func(int r, int [][] map){
        
        if(r == map.length){
            answer ++;
            return; 
        }
        
        for(int c =0; c<map[0].length; c ++){                
            if(!isSatisfied(r,c, map)){
                continue;
            }  
            map[r][c] =1;
            func(r+1, map);
            map[r][c] =0;
        }
    }
    
    public static boolean isSatisfied (int r, int c, int [][] map){
        
        // 만약 세로에 있다면 
        for(int tr =r; tr>=0; tr--){
            if(map[tr][c]==1) return false;
        }

        // 우상향 대각선에 있으면
        int tc = c; 
        for(int tr =r; tr>=0; tr--, tc ++){
            if(tc>=map[0].length) break;
            
            if(map[tr][tc]==1) return false;
        }    
        
        // 좌상향 대각선에 있으면 
        tc = c; 
        for(int tr =r; tr>=0; tr--, tc --){
            if(tc<0) break;
            
            if(map[tr][tc]==1) return false;
        }          
        
        return true;
    }
    

       
}