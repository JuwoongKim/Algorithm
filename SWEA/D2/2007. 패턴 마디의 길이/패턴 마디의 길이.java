
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
        
		for(int i =1; i<=N; i++) {
			String temp = br.readLine();
			int answer = 0;
			for(int j=1; j<=10; j++) {
				if(temp.substring(0,j).equals(temp.substring(j, j*2))) {
					answer = j;
					break;
				}
			}
			System.out.printf("#%d %d%n",i,answer);
		}		
	}	
}
