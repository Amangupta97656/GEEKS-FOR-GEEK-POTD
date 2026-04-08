class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Move left pointer forward if the element is already 0
            while (left < right && arr[left] == 0) {
                left++;
            }
            
            // Move right pointer backward if the element is already 1
            while (left < right && arr[right] == 1) {
                right--;
            }
            
            // If left is still less than right, we found a 1 on the left 
            // and a 0 on the right. Swap them.
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}