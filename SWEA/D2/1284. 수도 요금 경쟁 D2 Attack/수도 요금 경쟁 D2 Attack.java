import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int P = inputs[0];
			int Q = inputs[1];
			int R = inputs[2];
			int S = inputs[3];
			int W = inputs[4];

			int answer = Math.min(getScoreA(P, W), getScoreB(Q, R, S, W));
			System.out.println(String.format("#%d %d", i, answer));
		}
	}

	public static int getScoreA(int P, int W) {
		return P * W;
	}

	public static int getScoreB(int Q, int R, int S, int W) {
		return (W > R) ? Q + (W - R) * S : Q;
	}

}
