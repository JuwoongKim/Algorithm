import java.util.*;
import java.util.stream.*;
import java.io.*;


class Point{
	int r ;
	int c ;
	String v;
	public Point(int r , int c , String v) {
		this.r = r;
		this.c =c;
		this.v =v;
	}
}


class Solution
{
	
	public static int [] dr = {0,1,0,-1};
	public static int [] dc = {1,0,-1,0};
	
	 public static void main(String args[]) throws Exception
	 {
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t=1; t<=T; t++) {
			 
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int R = Integer.parseInt(st.nextToken());
			 int C = Integer.parseInt(st.nextToken());
			 
			 String [][]map = new String[R][C];
			 
			 for(int i =0; i<R; i++)
				 map[i] = br.readLine().split("");
		
			 boolean check =true;
			 boolean isFinished = false;
			 for(int r =0 ; r<R; r++) {
				 for( int c =0; c <C; c++) {
					 if(!map[r][c].equals("?")) {
						 check = bfs(map,r,c);
						 isFinished = true;
						 break;
					 }
				 }
				 if(isFinished)break;
				 
			 }
			 
			 
			 if(check) System.out.printf("#%d possible%n", t);
			 else System.out.printf("#%d impossible%n", t);
		 }
	 }
	 
	 
	 public static boolean bfs(String [][]map, int r, int c ) {
		 
		 int R = map.length;
		 int C = map[0].length;
		 
		 boolean [][]visit = new boolean[R][C];
		 
		 Queue<Point> q = new LinkedList<>();
		 q.offer(new Point(r,c, map[r][c]));
		 visit[r][c] = true;
		 
		 while(!q.isEmpty()) {
			 
			 Point temp = q.poll();
			 
			 for(int i=0; i<4; i++) {
				 int nr = temp.r + dr[i];
				 int nc = temp.c + dc[i];
				 // 범위 벗어나면 통과 
				 if(nr>=R || nr<0 || nc>=C ||nc<0) continue;
				 
				 //만약 인접한 것이 같다면  
				 if(map[nr][nc].equals(temp.v)) return false;
				 
				 //만약 물음표라면 
				 if(map[nr][nc].equals("?")) {
					 if (temp.v.equals("#")) map[nr][nc] =".";
					 else map[nr][nc] ="#";
				 }
				 
				 //방문했다면 저장 x
				 if(visit[nr][nc]) continue;
				 
				 // 큐대입 + 방문표시 
				 visit[nr][nc] =true;
				 q.offer(new Point(nr,nc,map[nr][nc])); 
			 }
		 }

		 return true;
	 }
}