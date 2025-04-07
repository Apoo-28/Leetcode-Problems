class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total_sum = sum(nums)
        if total_sum % 2:
            return False
        subset_sum = total_sum // 2
        dp = [False] * (subset_sum + 1)
        dp[0] = True
        for num in nums:
            for _sum in reversed(range(num, subset_sum+1)):
                dp[_sum] = dp[_sum] or dp[_sum - num]
                if dp[subset_sum]:
                    return dp[subset_sum]     
        return dp[subset_sum]
        