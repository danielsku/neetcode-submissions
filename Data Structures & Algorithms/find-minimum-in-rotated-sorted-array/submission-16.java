// Resolve this

class Solution {
    public int findMin(int[] nums) {
        int size = nums.length;

        int l = 0;
        int r = size - 1;
        int m = -1;

        if (nums[r] > nums[l] || r == l)
            return nums[l];

        while (l <= r) {
            m = (l + r) / 2;

            if (m > 0 && nums[m] < nums[m - 1]) {
                return nums[m];
            } else if (nums[r] > nums[m]) {
                r = m - 1;
            } else  {
                l = m + 1;
            }
        }

        return nums[m];
    }
}
