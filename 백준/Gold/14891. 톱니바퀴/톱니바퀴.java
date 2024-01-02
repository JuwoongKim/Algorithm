import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static int[][] arrs = new int[4][8];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int r = 0; r < 4; r++) {
			arrs[r] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int idx = inputs[0] - 1;
			int mode = inputs[1];

			left(idx, mode * -1);
			right(idx, mode * -1);
			rotate(arrs[idx], mode);
		}

		int score = 0;

		for (int i = 0; i < 4; i++) {
			double temp = (arrs[i][0] == 0) ? 0 : Math.pow(2, i);
			score += temp;
		}

		System.out.println(score);
	}

	public static void left(int idx, int mode) {
		if (idx == 0) {
			return;
		}

		if (arrs[idx - 1][2] != arrs[idx][6]) {
			left(idx - 1, mode * -1);
			rotate(arrs[idx - 1], mode);
		}

	}

	public static void right(int idx, int mode) {
		if (idx == 3) {
			return;
		}

		if (arrs[idx][2] != arrs[idx + 1][6]) {
			right(idx + 1, mode * -1);
			rotate(arrs[idx + 1], mode);
		}

	}

	public static void rotate(int[] arr, int mode) {

		if (mode == 1) {
			int last = arr[arr.length - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = last;

		} else {
			int first = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = first;
		}
	}

}
