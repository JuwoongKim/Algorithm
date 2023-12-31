import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String[] inputs = br.readLine().split(" ");

			int sum = 0;
			for (String input : inputs) {
				int number = Integer.parseInt(input);
				if (number % 2 == 1) {
					sum += number;
				}
			}
			System.out.println(String.format("#%d %d", i, sum));
		}
	}
}