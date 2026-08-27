class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0){
                neg+=1;
            }else if(nums[i]>0) pos+=1;
        }
        if(neg>pos) return neg;
        return pos;
    }
}