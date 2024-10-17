package codingTest;
class Solution {
    public int solution(int[] foods) {
        long sum = 0;
        for (int food : foods) {
            sum += food;
        }

        if (sum % 3 != 0) {
            return 0; // 총합이 3으로 나누어 떨어지지 않으면 불가능
        }

        long target = sum / 3;
        long currentSum = 0;
        int count = 0, result = 0;

        for (int i = 0; i < foods.length - 1; i++) {
            currentSum += foods[i];

            if (currentSum == 2 * target) {
                result += count;
            }

            if (currentSum == target) {
                count++;
            }
        }

        return result;
    }
}
