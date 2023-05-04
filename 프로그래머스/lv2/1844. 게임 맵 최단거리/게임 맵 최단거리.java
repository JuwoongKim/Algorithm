import java.util.*;


class Point{
    int r;
    int c;
    int lv;
    
    public Point (int r, int c, int lv){
        this.r =r;
        this.c =c;
        this.lv =lv;
    }    
}

class Solution {
    
    public static int [] dr ={0,1,0,-1};
    public static int [] dc ={1,0,-1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        boolean isAnswer = false;
        
        int R = maps.length;
        int C = maps[0].length;
        boolean [][] visit = new boolean[R][C];
        
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,1));
        visit[0][0] =true;
        
        while(!q.isEmpty()){
            
            Point temp = q.poll();
            
            for(int i =0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];
                int nlv = temp.lv+1;

                // 범위를 벗어난다면 
                if(nr<0 || nr>=R || nc <0 || nc >= C) continue;
                
                // 벽이거나 방문했다면  
                if(maps[nr][nc]==0 || visit[nr][nc]) continue;
                
                // 정답이라면 
                if(nr == R-1 && nc == C-1){
                    isAnswer =true;
                    answer = nlv;
                    break;
                }
                
                // 그게아니라면 
                q.offer(new Point(nr, nc, nlv));
                visit[nr][nc] =true;
                
            }
            if(isAnswer)
                break;
        }
        
        
        if(!isAnswer) answer =-1;
        return answer;
    }
}