import java.util.*;


class Point{
    int r;
    int c;
    
    public Point(int r, int c){
        this.r = r;
        this.c = c;        
    }
}


class Solution {
    
    public static int [] dr = {0, 1, 0, -1};
    public static int [] dc = {1, 0, -1, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean [][] visit = new boolean [m][n];
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(picture[r][c]!=0 && !visit[r][c]){
                    numberOfArea ++;
                    int size = bfs(r,c,picture, visit);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int bfs(int r, int c, int[][] picture, boolean [][] visit){
        
        int m = picture.length;
        int n = picture[0].length;
        int color = picture[r][c];
        
        int cnt = 0; 
        Queue<Point> q = new LinkedList<>();
        
        cnt ++;
        visit[r][c]=true;
        q.offer(new Point(r,c));
        
        while(!q.isEmpty()){
            
            Point temp = q.poll();

            for(int i =0; i<4; i++){
                int nr = temp.r+dr[i];
                int nc = temp.c+dc[i];
                
                if(nr<0 || nr>=m || nc<0 || nc>=n ) continue;
                if(picture[nr][nc]!=color) continue;
                if(visit[nr][nc]) continue;
                
                // 조건만족시
                cnt ++;
                visit[nr][nc]=true;
                q.offer(new Point(nr,nc));
            }
        }
        
        
        return cnt;
    }
    
    
}