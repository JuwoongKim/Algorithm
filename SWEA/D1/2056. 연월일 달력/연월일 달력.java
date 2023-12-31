import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private static List<Integer> monthDate = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();

			boolean hasAnswer = true;

			String year = input.substring(0, 4);
			String month = input.substring(4, 6);
			hasAnswer = validateMonth(month);
			String date = input.substring(6, 8);
			hasAnswer = validateDate(month, date);

			String answer = (hasAnswer) ? year + "/" + month + "/" + date : "-1";
			System.out.println(String.format("#%d %s", i, answer));
		}
	}

	public static boolean validateMonth(String month) {
		int monthToInt = Integer.parseInt(month);
		if (monthToInt > 12 || monthToInt < 1) {
			return false;
		}
		return true;
	}

	public static boolean validateDate(String month, String date) {
		int monthToInt = Integer.parseInt(month);
		int dateToInt = Integer.parseInt(date);

		if (monthToInt > 12 || monthToInt < 1) {
			return false;
		}

		int maxMonthDate = monthDate.get(monthToInt - 1);
		if (dateToInt > maxMonthDate || dateToInt < 1) {
			return false;
		}

		return true;
	}

}
