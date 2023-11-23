//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2354 👎 0


package com.rocky.leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            for(int i=len/2-1; i>=0; i--) {
                maxHeadDown(nums, i, len-1);
            }
            for(int i=len-1; i>=k; i--) {
                int tmp = nums[0];
                nums[0] = nums[i];
                nums[i] = tmp;
                maxHeadDown(nums, 0, i-1);
            }
            return nums[k];
        }

        public void maxHeadDown(int[] nums, int start, int end) {
            int c = start;
            int l = 2*c + 1;
            int tmp = nums[c];

            for( ; l <= end; c=l,l=2*l+1) {
                if(l<end && nums[l] < nums[l+1]) {
                    l++;
                }
                if(tmp > nums[l]) {
                    break;
                } else {
                    nums[c] = nums[l];
                    nums[l] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}