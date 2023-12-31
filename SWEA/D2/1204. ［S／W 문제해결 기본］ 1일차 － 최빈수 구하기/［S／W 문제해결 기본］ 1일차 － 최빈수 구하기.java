import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int cnt = Integer.parseInt(br.readLine());

			Map<Integer, Integer> map = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toMap(
					score -> score,
					socrecnt -> 1,
					(existValue, newValue) -> existValue + newValue
				));

			int key = 0;
			int maxValue = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (maxValue < entry.getValue()) {
					maxValue = entry.getValue();
					key = entry.getKey();
					continue;
				}
				if (maxValue == entry.getValue() && key < entry.getKey()) {
					key = entry.getKey();
				}
			}

			System.out.println(String.format("#%d %d", cnt, key));
		}
	}
}
