import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[][] map;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int d;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] inputs2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int R = inputs[0];
		int C = inputs[1];
		int cr = inputs2[0];
		int cc = inputs2[1];
		d = inputs2[2];

		// 그래프 생성
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		map[cr][cc] = -1;
		answer++;

		while (true) {

			if (hasRoom(cr, cc)) {
				// 있다면
				d = moveDirection(d);
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (positiveValidate(nr, nc)) {
					cr = nr;
					cc = nc;
					map[cr][cc] = -1;
					answer++;
				}

			} else {
				int nr = cr - dr[d];
				int nc = cc - dc[d];
				if (negativeValidate(nr, nc)) {
					break;
				}
				cr = nr;
				cc = nc;
			}
		}

		System.out.println(answer);
	}

	public static int moveDirection(int direction) {
		direction--;
		return (direction == -1) ? 3 : direction;
	}

	public static boolean hasRoom(int cr, int cc) {

		boolean result = false;
		for (int i = 0; i < 4; i++) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
				continue;
			}
			if (map[nr][nc] == 0) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static boolean positiveValidate(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
			return false;
		}

		if (map[nr][nc] == 0) {
			return true;
		}

		return false;
	}

	public static boolean negativeValidate(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] == 1) {
			return true;
		}
		return false;
	}

}
