import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point {
	public int r;
	public int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	void setNextPoint(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {

	private static int[][] map;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			int size = Integer.parseInt(br.readLine());
			map = new int[size][size];

			int number = 1;
			Point p = new Point(0, 0);
			map[p.r][p.c] = number;
			int idx = 0;

			func(p, number, idx);

			System.out.println(String.format("#%d", i));
			for (int[] row : map) {
				StringBuilder sb = new StringBuilder();
				for (int ele : row) {
					sb.append(ele + " ");
				}
				System.out.println(sb.toString());
			}

		}
	}

	public static void func(Point p, int number, int mode) {

		if (number == map.length * map.length) {
			return;
		}

		while (true) {
			int nr = p.r + dr[mode];
			int nc = p.c + dc[mode];

			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) {
				break;
			}
			if (map[nr][nc] != 0) {
				break;
			}
			p.setNextPoint(nr, nc);
			number++;

			map[p.r][p.c] = number;
		}

		mode = (mode + 1) % 4;
		func(p, number, mode);
	}
}
