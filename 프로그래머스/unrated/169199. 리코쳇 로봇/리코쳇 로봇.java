import java.util.*;
import java.util.stream.*;

class Point{
    
    int r;
    int c;
    int level;
    
    public Point(int r, int c, int level){
        this.r = r;
        this.c = c;        
        this.level = level;
    }
     
}

class Solution {
    
    public static String [][] map;
    public static int [] dr = {0, 1, 0, -1};
    public static int [] dc = {1, 0, -1, 0};
    
    public int solution(String[] board) {
        
        int answer = Integer.MAX_VALUE;
      
        // map 정보생성 
        int N = board.length;
        map = new String [N][];
        for(int i =0; i<N; i++)
            map[i] = board[i].split("");

        
        // 시작지점 찾기 
        Point sp = getStartPoint();

        
        // BFS위한 큐 생성 
        Queue<Point> q = new LinkedList<>();
        map[sp.r][sp.c] ="V";
        q.offer(sp);
        
        boolean isFinished = false;
        
        while(!q.isEmpty()){
            
            Point cp = q.poll();
            
            for(int i =0; i<4; i++){

                // 다음 포인트를 구한다.
                Point np = getNextPoint(i, cp);
                int nr = np.r;
                int nc = np.c;
                
                // 방문한 것이면 컨티뉴
                if(map[nr][nc].equals("V")) continue;                
                
                // 목표라면 값 비교 후 리턴 
                if(map[nr][nc].equals("G")){
                    answer = cp.level+1;
                    isFinished = true;
                    break;
                }
                
                // 아무것도 아니면 방문 후 다음
                map[nr][nc] = "V";
                q.offer(np);
                
            }            
            if(isFinished) break;
        }
        
        
        if(answer == Integer.MAX_VALUE) answer =-1;
        return answer;
    }

    
    
    
    public static Point getStartPoint(){
        
        int R = map.length;
        int C = map[0].length;
        
        for(int r =0; r<R; r++)
            for(int c =0; c<C; c++)
                if(map[r][c].equals("R"))
                    return new Point(r,c,0);
        
        return new Point(-1,-1,0);
    }
    
    public static Point getNextPoint(int type, Point cp){
        
        int nr = cp.r;
        int nc = cp.c;
        
        int R = map.length;
        int C = map[0].length;
        
        while(true){
            
            if(nr>=R || nr<0 || nc>=C || nc<0 || map[nr][nc].equals("D"))   break;
            nr += dr[type];
            nc += dc[type];
        }

        nr -= dr[type];
        nc -= dc[type];
     
        return new Point(nr,nc, cp.level+1);
    
    }
    
    
    
    
    
    
}