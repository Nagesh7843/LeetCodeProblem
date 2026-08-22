class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++){
            int s = 0;
            while(s < nums2.length){
                if(nums1[i] == nums2[s]){
                    if (!list.contains(nums1[i])) {
                        list.add(nums1[i]);
                    }

                    break;
                }
                s++;
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}