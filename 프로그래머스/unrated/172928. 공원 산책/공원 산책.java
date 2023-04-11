import java.util.*;
import java.util.stream.*;

class Solution {
    
    public static String [][] map;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        //map 정보입렵 
        int N = park.length;
        map = new String [N][];
        for(int i =0; i<N; i++)
            map[i] = park[i].split("");
        
        //Stream.of(map).forEach(r -> System.out.println(Arrays.toString(r)));
       int [] point = getStartPoint();
        
        // 명령에 따라 작업 실행
        StringTokenizer st;
        for(String  route :  routes){
            //System.out.println(point[0] + "  " + point[1]);
            st = new StringTokenizer(route);
            String op = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            int [] testPoint  = getTestPoint(point, op, n);
            if(testPoint[0]==-1 && testPoint[1]==-1) continue;
            point = testPoint;
        }
                
        answer =point;
        
        return answer;
    }
    
    
    public static int [] getTestPoint(int [] point, String op, int n){
    
        int [] dr = new int []{0,1,0,-1};
        int [] dc = new int []{1,0,-1,0};
        int idx = 0;

        switch(op){
            case "E" :idx=0; break;  
            case "S" :idx=1; break;                
            case "W" :idx=2; break;
            case "N" :idx=3; break;               
        }
                
        int tr= point[0];
        int tc= point[1];
         

        int R = map.length; 
        int C = map[0].length;
        for(int i =0; i<n; i++){
            tr += dr[idx];
            tc += dc[idx];
            if(tr>=R || tr<0 || tc>=C || tc<0 || map[tr][tc].equals("X")) return new int[]{-1,-1};
            
        }
        
        return new int[]{tr,tc};
    }
    
    
    public static int [] getStartPoint(){
        
        int [] point = new int [] {};
        
        int R = map.length; 
        int C = map[0].length;
        
        for(int r=0; r<R; r++){
            for(int c =0; c<C; c++){
                if(map[r][c].equals("S")){
                    point = new int [] {r,c};
                    break;
                }
            }
        }
        
        return point;
    }
    
    
}