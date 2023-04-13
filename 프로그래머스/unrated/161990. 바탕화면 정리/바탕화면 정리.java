import java.util.*;

class Solution {
    
    public static String [][] map;
    
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int N = wallpaper.length;
        map = new String [N][];
        for(int i =0; i<N; i++)
            map[i]=wallpaper[i].split("");
        
        int rmin = Integer.MAX_VALUE; 
        int rmax = Integer.MIN_VALUE;
        int cmin = Integer.MAX_VALUE; 
        int cmax = Integer.MIN_VALUE;        

        int R = map.length;
        int C = map[0].length;
        
        for(int r =0; r<R; r++){
            for(int c =0; c<C; c++){
                if(map[r][c].equals("#")){
                    rmin =Math.min(rmin, r );
                    cmin =Math.min(cmin, c );
                    rmax =Math.max(rmax, r );
                    cmax =Math.max(cmax, c );
                }
            }
        }
        rmax++;
        cmax++;
        answer = new int [] {rmin,cmin,rmax,cmax};        
        return answer;
    }
        
    
}