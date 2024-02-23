import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Integer.parseInt(br.readLine());
		int arr[] = new int[6];
		long ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long first = Math.min(arr[0], arr[5]);
		long second = Math.min(arr[1], arr[4]);
		long third = Math.min(arr[2], arr[3]);
		
		long sortArr[] = new long[3];
		sortArr[0] = first;
		sortArr[1] = second;
		sortArr[2] = third;
		Arrays.sort(sortArr);
		first = sortArr[0];
		second = sortArr[1];
		third = sortArr[2];
		
		int sum = 0;
		int max = 0;
		if(n == 1) {
			for(int i=0; i<6; i++) {
				sum += arr[i];
			}
			for(int i=0; i<6; i++) {
				max = Math.max(max, arr[i]);
			}
			ans = sum - max;
		}
		else {
			ans += (4 * (n - 1) * (n - 2) + (n - 2) * (n - 2)) * first;
			ans += (((n-2) * 2 * 4) + (n-1) * 4 * 2) / 2 * first;
			ans += 4 * first;
			
			ans += (((n-2) * 2 * 4) + (n-1) * 4 * 2) / 2  * second;
			ans += 4 * second;
			
			ans += 4 * third;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}