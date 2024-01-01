import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int[][] map;
	private static int[][] first;
	private static int[][] second;
	private static int[][] third;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {

			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			first = new int[N][N];
			second = new int[N][N];
			third = new int[N][N];

			for (int r = 0; r < N; r++) {
				map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			rotate(map, first);
			rotate(first, second);
			rotate(second, third);

			System.out.println(String.format("#%d", i));
			for (int r = 0; r < N; r++) {
				StringBuilder sb = new StringBuilder();

				for (int c = 0; c < N; c++) {
					sb.append(first[r][c]);
				}
				sb.append(" ");
				for (int c = 0; c < N; c++) {
					sb.append(second[r][c]);
				}
				sb.append(" ");
				for (int c = 0; c < N; c++) {
					sb.append(third[r][c]);
				}
				System.out.println(sb.toString());
			}
		}
	}

	public static void rotate(int[][] from, int[][] to) {
		int max = from.length - 1;
		for (int r = 0; r <= max; r++) {
			for (int c = 0; c <= max; c++) {
				to[c][max - r] = from[r][c];
			}
		}
	}
}
