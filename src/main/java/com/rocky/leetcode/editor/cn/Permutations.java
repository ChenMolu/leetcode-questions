package com.rocky.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            int[] vis = new int[25];
            backTracing(nums, vis);
            return result;
        }

        public void backTracing(int[] nums, int[] vis) {
            if(path.size() == nums.length) {
                result.add(new ArrayList(path));
                return;
            }
            for(int i=0; i< nums.length; i++) {
                if(vis[nums[i]+10] == 1) {
                    continue;
                }
                path.add(nums[i]);
                vis[nums[i] + 10] = 1;
                backTracing(nums, vis);
                path.removeLast();
                vis[nums[i] + 10] =0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}