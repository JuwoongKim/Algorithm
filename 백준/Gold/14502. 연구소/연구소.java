import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int r;
	int c;

	public Point() {
	}

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public void setPoint(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {

	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int R = nums[0];
		int C = nums[1];

		int[][] map = new int[R][C];

		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int max = R * C;
		Point one = new Point();
		Point two = new Point();
		Point three = new Point();

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < max - 2; i++) {
			for (int j = i + 1; j < max - 1; j++) {
				for (int k = j + 1; k < max; k++) {
					one.setPoint(i / C, i % C);
					two.setPoint(j / C, j % C);
					three.setPoint(k / C, k % C);
					if (!canPoint(map, one, two, three)) {
						continue;
					}
					int[][] copyMap = copyArr(map);
					setMap(copyMap, one, two, three);
					compute(copyMap);
					answer = Math.max(answer, getSafeSize(copyMap));
				}
			}
		}
		System.out.println(answer);

	}

	private static boolean canPoint(int[][] map, Point one, Point two, Point three) {
		if (map[one.r][one.c] != 0 || map[two.r][two.c] != 0 || map[three.r][three.c] != 0) {
			return false;
		}
		return true;
	}

	private static void setMap(int[][] map, Point one, Point two, Point three) {
		map[one.r][one.c] = 1;
		map[two.r][two.c] = 1;
		map[three.r][three.c] = 1;
	}

	private static void compute(int[][] map) {
		int R = map.length;
		int C = map[0].length;

		Point point = new Point();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2) {
					point.setPoint(r, c);
					bfs(map, point);
				}
			}
		}
	}

	private static int bfs(int[][] map, Point point) {
		int R = map.length;
		int C = map[0].length;
		Queue<Point> q = new LinkedList<>();
		q.offer(point);

		int result = 0;
		while (!q.isEmpty()) {
			Point poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = poll.r + dr[i];
				int nc = poll.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != 0) {
					continue;
				}
				result++;
				map[nr][nc] = -1;
				q.offer(new Point(nr, nc));
			}
		}

		return result;
	}

	public static int[][] copyArr(int[][] map) {
		int[][] copy = new int[map.length][map[0].length];

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				copy[r][c] = map[r][c];
			}
		}
		return copy;
	}

	public static int getSafeSize(int[][] map) {
		int safeSize = 0;
		int R = map.length;
		int C = map[0].length;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					safeSize++;
				}
			}
		}
		return safeSize;
	}

}
