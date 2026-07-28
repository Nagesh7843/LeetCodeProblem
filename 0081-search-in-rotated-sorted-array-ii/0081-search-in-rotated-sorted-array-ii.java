class Solution {
    public boolean search(int[] nums, int target) {
        
        int nl = nums.length - 1;

        for(int i = 0; i <= nl; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}