import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			
			String [][] map = new String [8][8];
			
			for(int i =0; i<8; i++) 
				map[i] = br.readLine().split(""); 			
			
			
			boolean check = true;
			int cnt =0;
			for(int r = 0 ; r < 8; r ++) {
				for(int c =0 ; c<8; c ++) {
					
					if(map[r][c].equals("O")) {
						cnt ++;
						if(cnt>8|| !isSatisfied(map, r, c)) {
							check = false;
							break;
						}
						
					}
					
				}
				if(!check) break;
			}
					
            if(cnt!=8) check= false;
            
			if(check) System.out.printf("#%d yes%n", t);
			else System.out.printf("#%d no%n", t);
		}	
	}	
	
	public static boolean isSatisfied(String [][] map, int r, int c) {
				
		// 행검사 
		for(int tc=0 ; tc<8; tc ++) {
			if(tc==c) continue;
			if(map[r][tc].equals("O")) return false;
		}
		
		// 열검사 
		for(int tr =0; tr<8; tr++) {
			if(tr ==r) continue;
			if(map[tr][c].equals("O")) return false;
		}
		
		return true;
	}
}