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
			int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = inputs[0];
			int K = inputs[1];
			
			map = new int[N][];
			for (int j = 0; j < N; j++) {
				map[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int answer = 0;

			answer += rowScan(map, K);
			answer += colScan(map, K);

			System.out.println(String.format("#%d %d", i, answer));
		}
	}

	public static int rowScan(int[][] map, int k) {
		int row_answer = 0;

		for (int r = 0; r < map.length; r++) {

			int cnt = 0;
			for (int c = 0; c < map.length; c++) {
				if (map[r][c] == 0) {
					if (cnt == k) {
						row_answer++;
					}
					cnt = 0;
					continue;
				}
				cnt++;
			}
			if (cnt == k) {
				row_answer++;
			}
		}
		return row_answer;
	}

	public static int colScan(int[][] map, int k) {
		int col_answer = 0;

		for (int c = 0; c < map.length; c++) {

			int cnt = 0;
			for (int r = 0; r < map.length; r++) {
				if (map[r][c] == 0) {
					if (cnt == k) {
						col_answer++;
					}
					cnt = 0;
					continue;
				}
				cnt++;
			}
			if (cnt == k) {
				col_answer++;
			}
		}

		return col_answer;
	}

}
