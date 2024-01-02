import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static int[] dr = {0, 0, 0, -1, 1};
	private static int[] dc = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int R = inputs[0];
		int C = inputs[1];
		int cr = inputs[2];
		int cc = inputs[3];
		int N = inputs[4];

		int[][] map = new int[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[] cmds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] diceInfo = {1, 6, 3, 4, 2, 5};
		Map<Integer, Integer> score = new HashMap<Integer, Integer>() {{
			put(1, 0);
			put(2, 0);
			put(3, 0);
			put(4, 0);
			put(5, 0);
			put(6, 0);
		}};

		for (int cmd : cmds) {
			int nr = cr + dr[cmd];
			int nc = cc + dc[cmd];

			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
				continue;
			}

			cr = nr;
			cc = nc;
			diceInfo = moveDice(diceInfo, cmd);
			
			if (map[cr][cc] == 0) {
				map[cr][cc] = score.get(diceInfo[1]);
			} else {
				score.put(diceInfo[1], map[cr][cc]);
				map[cr][cc] = 0;
			}

			System.out.println(score.get(diceInfo[0]));
		}
	}

	public static int[] moveDice(int[] diceInfo, int cmd) {

		switch (cmd) {
			case 1:
				return new int[] {diceInfo[3], diceInfo[2], diceInfo[0], diceInfo[1], diceInfo[4], diceInfo[5]};

			case 2:
				return new int[] {diceInfo[2], diceInfo[3], diceInfo[1], diceInfo[0], diceInfo[4], diceInfo[5]};

			case 3:
				return new int[] {diceInfo[5], diceInfo[4], diceInfo[2], diceInfo[3], diceInfo[0], diceInfo[1]};

			case 4:
				return new int[] {diceInfo[4], diceInfo[5], diceInfo[2], diceInfo[3], diceInfo[1], diceInfo[0]};
		}
		return null;
	}

}
