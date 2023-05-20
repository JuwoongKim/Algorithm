import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			int N = Integer.parseInt(br.readLine());			
			int y =3;	
			int x = y+N;
			while(true) {
				if(isSatisfied(x) && isSatisfied(y))
					break;		
				y ++;	
				x ++;
			}
			System.out.printf("#%d %d %d%n", t, x, y);
		}	
	}
	
	public static boolean isSatisfied(int num) {
		
		int bd = (int)Math.sqrt(num);
		
		for(int i =2; i<=bd; i++) {
			if(num%i==0) {
				return true;
			}
		}
		return false;
	}
}
