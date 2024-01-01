import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			String input = br.readLine();

			int answer = 0;
			for (int length = 1; length <= 10; length++) {
				String first = input.substring(0, length);
				String second = input.substring(length, 2 * length);
				String third = input.substring(2 * length, 3 * length);

				if (first.equals(second) && first.equals(third)) {
					answer = length;
					break;
				}
			}
			System.out.println(String.format("#%d %d", i, answer));
		}
	}
}
