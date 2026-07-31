class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
         int n = grid.length;
        int total = n * n;

        for (int[] row : grid) {
            for (int num : row) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        for(int i = 1; i <= total; i++){
            int freq = map.getOrDefault(i, 0);

            if(freq == 2){
                arr[0] = i;
            }
            if(freq == 0){
                arr[1] = i;
            }
        }
    return arr;
    }
}