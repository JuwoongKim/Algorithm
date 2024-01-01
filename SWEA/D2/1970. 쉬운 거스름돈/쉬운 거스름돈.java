import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

		for (int i = 1; i <= tc; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] counts = new int[moneys.length];

			for (int j = 0; j < moneys.length; j++) {
				counts[j] = N / moneys[j];
				N = N % moneys[j];
			}

			StringBuilder sb = new StringBuilder();
			Arrays.stream(counts).forEach(count -> sb.append(count + " "));

			System.out.println(String.format("#%d", i));
			System.out.println(sb.toString());
		}
	}

}
