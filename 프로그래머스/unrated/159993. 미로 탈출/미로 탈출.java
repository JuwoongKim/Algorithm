import java.util.*;

class Point{
    
    int r ;
    int c ; 
    int lv;
    public Point(int r, int c, int lv ){
        this.r = r;
        this.c = c;
        this.lv =lv;
    }
}


class Solution {
    
    public static int [] dr = {0,1,0,-1};
    public static int [] dc = {1,0,-1,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        // 최단거림으로 bfs 
        // 시작에서 레버까지, 레버에서 출구까지 .. 함수화 
        // System.out.println(Arrays.toString(ep));
        
        Point sp = getPoint("S",maps);
        Point ep = getPoint("E",maps);
        Point lp = getPoint("L",maps);

        int s1 = getMinTime(sp, lp, maps);
        int s2 = getMinTime(lp, ep, maps);
        answer = (s1==-1||s2==-1) ? -1 : s1+s2;
        
        return answer;
    }
    
    public static int  getMinTime(Point sp, Point ep, String[] maps){
        
        int R = maps.length;
        int C = maps[0].length();
        boolean [][] visit = new boolean [R][C];
        
        Queue<Point> q = new LinkedList<>();

        
        visit[sp.r][sp.c] = true;
        q.offer(sp);

        while(!q.isEmpty()){
            
            Point cp = q.poll();
            
            for(int i =0; i<4; i++){
                int nr = cp.r+dr[i];
                int nc = cp.c+dc[i];
                
                // 도착지라면 
                if(nr==ep.r && nc ==ep.c) return cp.lv+1;
                // 배열의 범위를 벗어난다면..  
                if(nr>=R || nr<0 || nc>=C || nc<0) continue;
                // 방문한 것 또는 벽이라면... 
                if(visit[nr][nc] || maps[nr].substring(nc, nc+1).equals("X")) continue;
                //그게 아니라면 
                visit[nr][nc] = true;   // 방문처리 
                q.offer(new Point(nr,nc, cp.lv+1));
                
            }

        }
        
        return -1;

    }
    
    
    
    public static Point getPoint(String s, String[] maps){
        
        int R = maps.length;
        int C = maps[0].length();
        
        for(int r=0; r<R; r++)
            for(int c=0; c<C; c++)
                if(maps[r].substring(c,c+1).equals(s))
                    return new Point(r,c,0);
                
        return new Point(-1,-1,0);                             
    }
    
    
}