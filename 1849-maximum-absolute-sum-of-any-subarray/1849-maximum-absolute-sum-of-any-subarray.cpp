class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int sum = 0, maxp = 0, minp = 0;
        for(int& num : nums){
            sum += num;
            maxp = max(maxp, sum);
            minp = min(minp, sum);
        }
        return maxp -minp;
    }
};