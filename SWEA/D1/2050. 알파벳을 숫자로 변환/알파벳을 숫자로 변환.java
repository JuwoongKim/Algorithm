import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] charArray = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : charArray) {
			int num = c - 64;
			sb.append(num + " ");
		}

		System.out.println(sb.toString());
	}
}
