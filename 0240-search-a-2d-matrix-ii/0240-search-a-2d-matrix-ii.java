class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {

            int s = 0;
            int e = matrix[row].length - 1;

            while (s <= e) {

                int mid = s + (e - s) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                }

                if (target > matrix[row][mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return false;
    }
}