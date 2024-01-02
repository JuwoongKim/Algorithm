import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static int answer = 0;
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	public static int[][] map;
	public static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int R = sizeInfo[0];
		int C = sizeInfo[1];

		map = new int[R][C];
		isVisit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// DFS로 할 수 있는 것
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				isVisit[r][c] = true;
				int score = map[r][c];
				dfs(r, c, score, 1);
				isVisit[r][c] = false;
			}
		}

		// 예외 처리
		// 아래
		for (int r = 0; r <= R - 2; r++) {
			for (int c = 0; c <= C - 3; c++) {
				int temp = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1];
				answer = Math.max(answer, temp);
			}
		}
		// 위
		for (int r = 0; r <= R - 2; r++) {
			for (int c = 0; c <= C - 3; c++) {
				int temp = map[r + 1][c] + map[r + 1][c + 1] + map[r + 1][c + 2] + map[r][c + 1];
				answer = Math.max(answer, temp);
			}
		}
		// 오른
		for (int r = 0; r <= R - 3; r++) {
			for (int c = 0; c <= C - 2; c++) {
				int temp = map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1];
				answer = Math.max(answer, temp);
			}
		}
		// 왼
		for (int r = 0; r <= R - 3; r++) {
			for (int c = 0; c <= C - 2; c++) {
				int temp = map[r][c + 1] + map[r + 1][c + 1] + map[r + 2][c + 1] + map[r + 1][c];
				answer = Math.max(answer, temp);
			}
		}

		System.out.println(answer);

	}

	private static void dfs(int r, int c, int score, int level) {

		if (level == 4) {
			answer = Math.max(answer, score);
			return;
		}

		isVisit[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || isVisit[nr][nc]) {
				continue;
			}

			isVisit[nr][nc] = true;
			score += map[nr][nc];
			level++;

			dfs(nr, nc, score, level);

			isVisit[nr][nc] = false;
			score -= map[nr][nc];
			level--;
		}
	}

}
