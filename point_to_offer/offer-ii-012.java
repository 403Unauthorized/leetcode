// 剑指 Offer II 012. 左右两边子数组的和相等 - Easy
// https://leetcode-cn.com/problems/tvdfij/
package point_to_offer;

class OfferII012 {
    /**
     * 先算出nums的前缀和数组prefix
     * 然后从1到prefix.length - 1遍历数组
     * 如果 prefix[i - 1] == prefix[prefix.length - 1] - prefix[i]
     * 上面这个判断就是判断nums当前索引左侧的和是否等于右侧的和
     * 如果相等则返回i
     * 没有符合条件的就返回-1
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len + 1];
        prefix[0] = 0;
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        for (int i = 1; i <= len; i++) {
            if (prefix[i - 1] == prefix[len] - prefix[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
