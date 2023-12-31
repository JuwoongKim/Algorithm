import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			double answer = Arrays.stream(br.readLine().split(" "))
				.mapToDouble(Double::parseDouble)
				.average()
				.orElseThrow(() -> new RuntimeException());

			System.out.println(String.format("#%d %d", i, Math.round(answer)));
		}
	}
}