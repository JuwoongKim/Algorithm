
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		for(int i =1; i<=N; i++) {
		
			int size = Integer.parseInt(br.readLine());
			int [] arr = new int [] {1};
			System.out.println("#"+i);
			for(int j=1; j<=size; j++) {
				
				if(j==1) {
					print(arr);
					continue;
				}
				
				int [] temp = new int [j];
				for(int k=0; k<j;k++) {
					if(k==0) {
						temp[k] = arr[0];
						continue;
					}else if (k ==j-1) {
						temp[k] = arr[arr.length-1];
						continue;
					}else {
						temp[k] = arr[k-1] + arr[k];
						continue;
					}
				}
				print(temp);
				arr= temp;	
			}
		}		
	}
	
	public static void print(int [] arr) {
		StringBuilder sb = new StringBuilder("");
		for(int ele : arr)
			sb.append(String.format("%d ", ele));
		System.out.println(sb.toString());
			
	}
}