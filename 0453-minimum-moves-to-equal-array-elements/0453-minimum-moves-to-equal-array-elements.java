class Solution {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        for (int num : nums) {
            result += num - min;
        }

        return result;
    }
}