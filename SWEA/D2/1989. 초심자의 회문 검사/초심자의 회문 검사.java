import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {

			char[] inputs = br.readLine().toCharArray();
			int lt = 0;
			int rt = inputs.length - 1;

			int answer = 1;

			while (lt <= rt) {
				if (inputs[lt] != inputs[rt]) {
					answer = 0;
					break;
				}
				lt++;
				rt--;
			}

			System.out.println(String.format("#%d %d", i, answer));
		}
	}
}
