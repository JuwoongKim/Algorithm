import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	

			int R = Integer.parseInt(br.readLine());
			
			// 원점 
			int zero = 1;
			// x축 y축 
			int l = R*4;
			// 사이의 점 
			int cnt =0;
			for(int x=1; x<=R; x++) {
				for(int y=1; y<=R; y++)
					if(Math.pow(R, 2)>= Math.pow(x, 2)+ Math.pow(y, 2)) 
						cnt++;	
			}
			
			int answer = zero + l + cnt*4;

			System.out.printf("#%d %d%n", t, answer);
		}	
	}	
}