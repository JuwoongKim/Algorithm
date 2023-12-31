import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

			String symbol;
			if (inputs.get(0) > inputs.get(1)) {
				symbol = ">";
			} else if (inputs.get(0) == inputs.get(1)) {
				symbol = "=";
			} else {
				symbol = "<";
			}
			System.out.println(String.format("#%d %s", i, symbol));
		}
	}
}
