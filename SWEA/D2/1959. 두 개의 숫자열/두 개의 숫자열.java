import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {

			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = input[0];
			int M = input[1];

			int[] Aarr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] Barr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int answer = (N >= M) ? compute(Aarr, Barr) : compute(Barr, Aarr);

			System.out.println(String.format("#%d %d", i, answer));
		}
	}

	public static int compute(int[] outer, int[] inner) {
		int O = outer.length;
		int I = inner.length;

		int answer = 0;
		for (int i = 0; i <= O - I; i++) {
			int tempSum = 0;
			for (int j = 0; j < inner.length; j++) {
				tempSum += (outer[i+j] * inner[j]);
			}
			answer = Math.max(answer, tempSum);
		}

		return answer;
	}

}
