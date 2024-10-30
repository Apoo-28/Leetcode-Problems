class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // Step 1: Create and populate the inc array
        int[] inc = new int[n];
        Arrays.fill(inc, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // Step 2: Create and populate the dec array
        int[] dec = new int[n];
        Arrays.fill(dec, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // Step 3: Find the maximum value of inc[i] + dec[i] - 1
        int maxLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (inc[i] > 1 && dec[i] > 1) {
                maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
            }
        }

        // Step 4: Calculate the minimum number of removals
        return n - maxLen;
    }
}