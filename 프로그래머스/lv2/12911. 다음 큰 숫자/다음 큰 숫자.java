public class Solution {
    public int solution(int n) {
        int targetOnes = countOnes(n);  // n의 이진수에서 1의 개수
        int nextNum = n + 1;

        while (true) {
            if (countOnes(nextNum) == targetOnes) {
                return nextNum;
            }
            nextNum++;
        }
    }

    private int countOnes(int num) {
        // 이진수로 변환한 후, 1의 개수를 센다.
        String binary = Integer.toBinaryString(num);
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}