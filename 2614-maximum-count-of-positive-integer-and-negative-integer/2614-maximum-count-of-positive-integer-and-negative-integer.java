class Solution {
    public int maximumCount(int[] nums) {
        int lastIdxNeg = -1;
        int firstIdxPos = nums.length;

        // find the last index of the negative element
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                lastIdxNeg++;
            }
        }

        System.out.println("last idex of negative element: " + lastIdxNeg);

        // find the first index of the positive element
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > 0) {
                firstIdxPos--;
            }
        }

        System.out.println("first idex of positive element: " + firstIdxPos);
        return Math.max(lastIdxNeg + 1, nums.length - firstIdxPos);
    }
}