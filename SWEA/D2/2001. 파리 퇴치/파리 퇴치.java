import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {

			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = input[0];
			int M = input[1];

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int maxSum = Integer.MIN_VALUE;
			for (int r = 0; r <= N - M; r++) {
				for (int c = 0; c <= N - M; c++) {
					maxSum = Math.max(maxSum, sum(r, c, M));
				}
			}

			System.out.println(String.format("#%d %d", i, maxSum));
		}
	}

	public static int sum(int R, int C, int M) {
		int answer = 0;
		for (int r = R; r < R + M; r++) {
			for (int c = C; c < C + M; c++) {
				answer += map[r][c];
			}
		}
		return answer;
	}

}
