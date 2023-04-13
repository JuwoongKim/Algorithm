import java.util.*;
import java.util.stream.*;

class Solution {

    public static String [][]map;
    public static boolean [][] visit;
    
    public static int [] dr = {0,1,0,-1} ;
    public static int [] dc = {1,0,-1,0} ;
    
    
    
    public int[] solution(String[] maps) {
        
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();

        
        int R =maps.length;
        int C = maps[0].length();
            
        map = new String [R][C];
        visit = new boolean[R][C];
        for(int r =0; r<R; r++)
            map[r] = maps[r].split("");
        
        //순회하면서 방문하지 않은 무인도 발견시 dfs 진행 
        for(int r =0; r<R; r++ ){
            for(int c =0; c<C; c++){
                if(!map[r][c].equals("X") && !visit[r][c]){
                    visit[r][c] = true;
                    answerList.add(dfs(r,c));
                    // Stream.of(visit).forEach(row-> System.out.println(Arrays.toString(row)));
                    // System.out.println();
                }     
            }
        }
        
        if(answerList.size()==0) return new int [] {-1};
        Collections.sort(answerList);
        answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
    
    public static int dfs (int r, int c){

        int R =map.length;
        int C = map[0].length;
        
        int temp =Integer.parseInt(map[r][c]);
        for(int i =0; i<4; i++){
         
            int nr= r + dr[i];
            int nc= c + dc[i];
            if(nr>=R || nr<0 || nc>=C || nc< 0)continue;
            if(map[nr][nc].equals("X") || visit[nr][nc]) continue;
            
            visit[nr][nc] = true;
            temp+= dfs(nr,nc);
            //visit[nr][nc] = false;
        }
        return temp;
    }    
    
    
}