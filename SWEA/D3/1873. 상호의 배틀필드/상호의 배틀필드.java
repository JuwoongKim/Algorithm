import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			String [][] map = new String [H][W];
			
			for(int i =0; i<H; i++)
				map[i] = br.readLine().split("");
			
			String nn= br.readLine();
			String cmd = br.readLine();
			
			play(map, cmd);
			
			System.out.printf("#%d ",t);
			for(String [] row : map) {
				StringBuilder sb = new StringBuilder("");
				for(String ele : row)
					sb.append(ele);
				System.out.println(sb.toString());
			}
		}	
	}	
	
	
	public static void play(String[][] map, String cmd ) {
		
		int [] cp = getCp(map);
		int r = cp[0];
		int c = cp[1];
		
		for(int i =0; i<cmd.length(); i++) {
			
			switch(cmd.charAt(i)) {
			
			case 'U':
				map[r][c] = "^";
				if(canGo(map, r-1,c)) {
					map[r][c] =".";
					map[r-1][c] ="^";
					r= r-1;
				}
				break;

			case 'D':
				map[r][c] = "v";
				if(canGo(map, r+1,c)) {
					map[r][c] =".";
					map[r+1][c] ="v";
					r= r+1;
				}
				break;
				
			case 'L':
				map[r][c] = "<";
				if(canGo(map, r,c-1)) {
					map[r][c] =".";
					map[r][c-1] ="<";
					c=c-1;
				}
				break;
				
			case 'R':
				map[r][c] = ">";
				if(canGo(map, r,c+1)) {
					map[r][c] =".";
					map[r][c+1] =">";
					c= c+1;
				}
				break;
				
			case 'S':
				shoot(map, r, c);
				break;
			}
		}
	}
	
	
	public static void shoot(String[][] map, int r, int c ) {

		int R = map.length;
		int C = map[0].length;
		
		switch(map[r][c]) {
		case "^":
			for(int nr=r; nr>=0; nr--) {
				if(map[nr][c].equals("*")) {
					map[nr][c] =".";
					break;
				}
				if(map[nr][c].equals("#")) {
					break;
				}
			}
			
			break;
			
		case "v":
			for(int nr=r; nr<R; nr++) {
				if(map[nr][c].equals("*")) {
					map[nr][c] =".";
					break;
				}
				if(map[nr][c].equals("#")) {
					break;
				}
			}
			
			break;
			
		case "<":
			for(int nc=c; nc>=0; nc--) {
				if(map[r][nc].equals("*")) {
					map[r][nc] =".";
					break;
				}
				if(map[r][nc].equals("#")) {
					break;
				}
			}

			break;
			
		case ">":
			for(int nc=c; nc<C; nc++) {
				if(map[r][nc].equals("*")) {
					map[r][nc] =".";
					break;
				}
				if(map[r][nc].equals("#")) {
					break;
				}
			}
			break;
		}
	}
	
	
	public static boolean canGo(String[][] map, int nr, int nc) {
		
		int R = map.length;
		int C = map[0].length;
		
		// 범위를 벗어난다면
		if(nr>=R || nr<0 || nc>=C || nc <0) return false;
			
		// 장애물이 있다면 
		String s = map[nr][nc];
		if(!s.equals(".")) return false;
		
		return true;
			
	}
	
	public static int [] getCp(String[][] map) {
		
		int []  cp = new int [2];
				
		for(int h =0; h<map.length; h ++) {
			for(int w =0 ; w<map[0].length; w++) {
				if(map[h][w].equals("<")||map[h][w].equals(">")||map[h][w].equals("^")||map[h][w].equals("v")) {
					cp[0]=h;  cp[1]=w;
					break;
				}
			}
		}	
		return cp;
	}
	
}