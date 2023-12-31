import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			Integer input = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();
			int cnt = 0;

			while (set.size() < 10) {
				cnt++;
				Integer temp = input * cnt;

				while (temp != 0) {
					int mod = temp % 10;
					set.add(mod);
					temp /= 10;
				}
			}

			input = input * cnt;
			System.out.println(String.format("#%d %d", i, input));
		}
	}
}
