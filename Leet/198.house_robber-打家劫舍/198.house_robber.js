/**
 * @param {number[]} nums
 * @return {number}
 */
// 【51-198. 打家劫舍】
var rob = function (nums) {
    let len = nums.length;
    if (!len) return 0;
    if (len === 1) return nums[0];
    const dp = new Array(len);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (let i = 2; i < len; i++) {
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[len - 1];
};