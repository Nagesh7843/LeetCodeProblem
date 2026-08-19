class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int totalEl = col * row - 1;
        int s = 0;
        int e = totalEl;

        while(s <= e){
            int mid = s + (e - s) / 2;
            int rowIdx = mid / col;
            int colIdx = mid % col;

            if(matrix[rowIdx][colIdx] == target){
                return true;
            }else if(matrix[rowIdx][colIdx] > target){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return false;
    }
}