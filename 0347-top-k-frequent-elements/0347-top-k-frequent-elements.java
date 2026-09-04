import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] unique = new int[map.size()];
        int index = 0;

        for (int num : map.keySet()) {
            unique[index++] = num;
        }

        quickSort(unique, 0, unique.length - 1, map);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = unique[i];
        }

        return ans;
    }

    static void quickSort(int[] nums, int low, int high,
                          HashMap<Integer, Integer> map) {

        if (low < high) {
            int pivotIndex = partition(nums, low, high, map);

            quickSort(nums, low, pivotIndex - 1, map);
            quickSort(nums, pivotIndex + 1, high, map);
        }
    }

    static int partition(int[] nums, int low, int high,
                         HashMap<Integer, Integer> map) {

        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (map.get(nums[j]) > map.get(pivot)) {
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }
}